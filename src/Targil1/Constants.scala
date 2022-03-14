package Targil1

object Constants {

  object CommandType {
    val C_ARITHMETIC: String = "C_ARITHMETIC"
    val C_PUSH: String = "C_PUSH"
    val C_POP: String = "C_POP"
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
      |M=M-1
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
      |@{index}
      |D=M
      |@SP
      |M=M+1
      |A=M-1
      |M=D
      |""".stripMargin

  val POP_STATIC: String =
    """
      |@SP
      |M=M-1
      |A=M
      |D=M
      |@{index}
      |M=D
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
  val POP_LCL_ARG_THIS_THAT: String = //TODO
    """
      |@SP
      |M=M-1
      |A=M
      |D=M
      |@{segment}
      |A=M `+index
      |M=D
      |""".stripMargin
}

