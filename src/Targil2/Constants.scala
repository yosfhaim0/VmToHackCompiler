package Targil2

object Constants {

  object CommandType {
    val C_ARITHMETIC: String = "C_ARITHMETIC"
    val C_PUSH: String = "C_PUSH"
    val C_POP: String = "C_POP"
    val C_LABEL: String = "C_LABEL"
    val C_GOTO: String = "C_GOTO"
    val C_IFGOTO: String = "C_IF-GOTO"
    val C_CALL: String = "C_CALL"
    val C_RETURN: String = "C_RETURN"
    val C_FUNCTION: String = "C_FUNCTION"
    val C_NOTHING: String = "" //TODO
  }

  object MemAccCmd {
    val LCL: String = "LCL"
    val ARG: String = "ARG"
    val THIS: String = "THIS"
    val THAT: String = "THAT"
    val PTR: String = "pointer"
    val TMP: String = "temp"
    val CONST: String = "constant"
    val STAT: String = "static"
  }

  object ArithmeticCmd {
    val ADD: String = "add"
    val SUB: String = "sub"
    val NEG: String = "neg"
    val EQ: String = "eq"
    val GT: String = "gt"
    val LT: String = "lt"
    val AND: String = "and"
    val OR: String = "or"
    val NOT: String = "not"
  }

  object JumpCmd {
    val LABEL: String = "label"
    val GOTO: String = "goto"
    val IFGOTO: String = "if-goto"
  }

  object FunctionCmd {
    val CALL: String = "call"
    val RETURN: String = "return"
    val FUNCTION: String = "function"
  }


  val ADD: String =
    """
      |@SP
      |M=M-1
      |A=M
      |D=M
      |A=A-1
      |M=D+M
      |""".stripMargin

  val SUB: String =
    """
      |@SP
      |M=M-1
      |A=M
      |D=M
      |A=A-1
      |M=M-D
      |""".stripMargin

  val NOT: String =
    """
      |@SP
      |M=M-1
      |A=M
      |D=!M
      |M=D
      |@SP
      |M=M+1
      |""".stripMargin

  val AND: String =
    """
      |@SP
      |M=M-1
      |A=M
      |D=M
      |@SP
      |M=M-1
      |A=M
      |D=D&M
      |M=D
      |@SP
      |M=M+1
      |""".stripMargin

  val OR: String =
    """
      |@SP
      |M=M-1
      |A=M
      |D=M
      |@SP
      |M=M-1
      |A=M
      |D=D|M
      |M=D
      |@SP
      |M=M+1
      |""".stripMargin

  val NEG: String =
    """
      |@SP
      |M=M-1
      |A=M
      |D=-M
      |M=D
      |@SP
      |M=M+1
      |""".stripMargin

  val EQ: String =
    """
      |@SP
      |M=M-1
      |A=M
      |D=M
      |@SP
      |M=M-1
      |A=M
      |D=M-D
      |@IF_TRUEval
      |D;JEQ
      |@SP
      |A=M
      |M=0
      |@IF_FALSEval
      |0;JMP
      |(IF_TRUEval)
      |@SP
      |A=M
      |M=-1
      |(IF_FALSEval)
      |@SP
      |M=M+1
      |""".stripMargin

  val GT: String =
    """
      |@SP
      |M=M-1
      |A=M
      |D=M
      |@SP
      |AM=M-1
      |D=M-D
      |@IF_TRUEval
      |D;JGT
      |@SP
      |A=M
      |M=0
      |@IF_FALSEval
      |0;JMP
      |(IF_TRUEval)
      |@SP
      |A=M
      |M=-1
      |(IF_FALSEval)
      |@SP
      |M=M+1
      |""".stripMargin

  val LT: String =
    """
      |@SP
      |M=M-1  //pop()
      |A=M
      |D=M
      |@SP
      |M=M-1
      |A=M
      |D=M-D
      |@IF_TRUEval
      |D;JLT
      |@SP
      |A=M
      |M=0
      |@IF_FALSEval
      |0;JMP
      |(IF_TRUEval)
      |@SP
      |A=M
      |M=-1
      |(IF_FALSEval)
      |@SP
      |M=M+1
      |""".stripMargin

  val PUSH_CONSTANT: String =
    """
      |@{index}
      |D=A
      |@SP
      |A=M
      |M=D
      |@SP
      |M=M+1
      |""".stripMargin

  val POP_CONSTANT: String =
    """
      |@SP
      |M=M-1
      |A=M
      |D=M
      |@{value}
      |M=D
      |""".stripMargin

  val PUSH_POINTER: String =
    """
      |@{index}
      |D=A
      |@3
      |A=A+D
      |D=M
      |@SP
      |A=M
      |M=D
      |@SP
      |M=M+1
      |""".stripMargin

  //'`+index' - invalid command, need to support with code
  val POP_POINTER: String = //YOSEF CAPARA ALECHA
    """
      |@SP
      |M=M-1
      |A=M
      |D=M
      |@3 `+index
      |M=D
      |""".stripMargin

  val PUSH_STATIC: String =
    """
      |@file.{index}
      |D=M
      |@SP
      |A=M
      |M=D
      |@SP
      |M=M+1
      |""".stripMargin

  val POP_STATIC: String =
    """
      |@SP
      |A=M-1
      |D=M
      |@file.{index}
      |M=D
      |@SP
      |M=M-1
      |""".stripMargin

  val PUSH_TEMP: String =
    """
      |@{index}
      |A=A+1
      |A=A+1
      |A=A+1
      |A=A+1
      |A=A+1
      |D=M
      |@SP
      |M=M+1
      |A=M-1
      |M=D
      |""".stripMargin

  val POP_TEMP: String =
    """
      |@SP
      |M=M-1
      |A=M
      |D=M
      |@{index}
      |A=A+1
      |A=A+1
      |A=A+1
      |A=A+1
      |A=A+1
      |M=D
      |""".stripMargin

  val PUSH_LCL_ARG_THIS_THAT: String =
    """
      |@{index}
      |D=A
      |@{segment}
      |A=M+D
      |D=M
      |@SP
      |A=M
      |M=D
      |@SP
      |M=M+1
      |""".stripMargin

  //'`+index' - invalid command, need to support with code
  val POP_LCL_ARG_THIS_THAT: String =
    """
      |
      |@SP
      |M=M-1
      |A=M
      |D=M
      |@{segment}
      |A=M `+index
      |M=D
      |""".stripMargin

  val GOTO: String =
    """
      |@FileName.c
      |0;JMP
      |""".stripMargin

  val LABEL: String =
    """
      |(FileName.c)
      |""".stripMargin
  val IFGOTO: String =
    """
      |@SP
      |M=M-1
      |A=M
      |D=M
      |@FileName.c
      |D;JNE
      |""".stripMargin

      //call funcname n
  val CALL: String =
    """
      |// push return-address
      |@NameOfFunc.ReturnAddress(index)
      |D=A
      |@SP
      |A=M
      |M=D
      |@SP
      |M=M+1
      |// push LCL
      |@LCL
      |D=M
      |@SP
      |A=M
      |M=D
      |@SP
      |M=M+1
      |// push ARG
      |@ARG
      |D=M
      |@SP
      |A=M
      |M=D
      |@SP
      |M=M+1
      |// push THIS
      |@THIS
      |D=M
      |@SP
      |A=M
      |M=D
      |@SP
      |M=M+1
      |// push THAT
      |@THAT
      |D=M
      |@SP
      |A=M
      |M=D
      |@SP
      |M=M+1
      |// ARG = SP-n-5
      |@SP
      |D=M
      |@numARG
      |D=D-A
      |@5
      |D=D-A
      |@ARG
      |M=D
      |// LCL = SP
      |@SP
      |D=M
      |@LCL
      |M=D
      |// goto g
      |@NameOfFunc
      |0;JMP
      |// label return-address
      |(NameOfFunc.ReturnAddress(index))
      |""".stripMargin
  val ret: String =
    """
      // FRAME = LCL
      |@LCL
      |D=M
      |// RET = * (FRAME-5)
      |// RAM[13] = (LOCAL - 5)
      |@5
      |A=D-A
      |D=M
      |@13
      |M=D
      |
      |// * ARG = pop()
      |@SP
      |M=M-1
      |A=M
      |D=M
      |@ARG
      |A=M
      |M=D
      |// SP = ARG+1
      |@ARG
      |D=M
      |@SP
      |M=D+1
      |
      |// THAT = *(FRAM-1)
      |@LCL
      |M=M-1
      |A=M
      |D=M
      |@THAT
      |M=D
      |
      |// THIS = *(FRAM-2)
      |@LCL
      |M=M-1
      |A=M
      |D=M
      |@THIS
      |M=D
      |// ARG = *(FRAM-3)
      |@LCL
      |M=M-1
      |A=M
      |D=M
      |@ARG
      |M=D
      |// LCL = *(FRAM-4)
      |@LCL
      |M=M-1
      |A=M
      |D=M
      |@LCL
      |M=D
      |// goto RET
      |@13
      |A=M
      |0;JMP
      |""".stripMargin
  var RETURN:String=
    """
      |//fream=lcl
      |@LCL
      |D=M
      |//ret=(fream-5)
      |@5
      |A=D-A
      |D=M
      |@13
      |//ram[13]=(fream/lcl-5)
      |M=D
      |//arg=pop()
      |@SP
      |M=M-1
      |A=M
      |D=M
      |@ARG
      |A=M
      |M=D
      |@ARG
      |D=M
      |@SP
      |M=D+1
      |@LCL
      |M=M-1
      |A=M
      |D=M
      |@THAT
      |M=D
      |@LCL
      |M=M-1
      |A=M
      |D=M
      |@THIS
      |M=D
      |@LCL
      |M=M-1
      |A=M
      |D=M
      |@ARG
      |M=D
      |@LCL
      |M=M-1
      |A=M
      |D=M
      |@LCL
      |M=D
      |@13
      |A=M
      |0;JMP
      |""".stripMargin
  val FUNCTION: String =
    """
      |// label g
      |(NameOfFunc)
      |@NumOfLocal
      |D=A
      |@NameOfFunc_End
      |D;JEQ
      |(NameOfFunc_Loop)
      |@SP
      |A=M
      |M=0
      |@SP
      |M=M+1
      |@NameOfFunc_Loop
      |D=D-1;JNE
      |(NameOfFunc_End)
      |
      |""".stripMargin
  val BOOTSTRAPPING: String =
    """|@256
       |D=A
       |@SP
       |M=D
       |@Sys.init.returnAdd
       |D=A
       |@SP
       |A=M
       |M=D
       |@SP
       |M=M+1
       |@LCL
       |D=M
       |@SP
       |A=M
       |M=D
       |@SP
       |M=M+1
       |@ARG
       |D=M
       |@SP
       |A=M
       |M=D
       |@SP
       |M=M+1
       |@THIS
       |D=M
       |@SP
       |A=M
       |M=D
       |@SP
       |M=M+1
       |@THAT
       |D=M
       |@SP
       |A=M
       |M=D
       |@SP
       |M=M+1
       |@SP
       |D=M
       |@0
       |D=D-A
       |@5
       |D=D-A
       |@ARG
       |M=D
       |@SP
       |D=M
       |@LCL
       |M=D
       |@Sys.init
       |0;JMP
       |(Sys.init.returnAdd)
       |""".stripMargin
}

