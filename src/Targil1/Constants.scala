package Targil1

object Constants {

  object CommandType {
    val C_ARITHMETIC: String = "C_ARITHMETIC"
    val C_PUSH: String = "C_PUSH"
    val C_POP: String = "C_POP"
    val C_NOTHING: String = ""//TODO
  }

  object MemAccCmd {
    val LCL: String = "local"
    val ARG: String = "argument"
    val THIS: String = "this"
    val THUS: String = "thus"
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

  /**
   * //  EXAMPLE: vm command: ADD
   *
   * @SP //  A = 0
   *     A=M-1  //  A = RAM[A]-1 = RAM[0]-1 = 258-1 = 257 => A=257
   *     D=M		//  D = RAM[A] = RAM[257] = 5
   *     //  D saves the second item in the stack
   *     A=A-1	//  A = 257-1 = 256
   *     M=D+M	//  RAM[A] = D+RAM[A] => RAM[256] = 5+RAM[256] = 5+4 = 9
   *     //  save the add result in the place of the first item on the stack
   *     //  this is equal to:  pop second item, pop first item,
   *     //  push the result of their addition to the stack.
   * @SP //  after pushing the result to the stack,
   *     //  we want to decrement the stack pointer.
   *     //  current command is: A=0
   *     M=M-1	//  RAM[A] = RAM[A]-1
   *     //  => RAM[0] = RAM[0] - 1
   *     //  => RAM[0] = 258-1 = 257.
   *     //  so now the stack pointer, saved in RAM[0], points to RAM[257]
   */
  val ADD: String =
    """
      |@SP
      |A=M-1
      |D=M
      |A=A-1
      |M=D+M
      |@SP
      |M=M-1
      |""".stripMargin

  val SUB: String =
    """
      @SP
      |A=M-1
      |D=M
      |A=A-1
      |M=D-M
      |@SP
      |M=M-1
      |""".stripMargin

  val NOT: String =
    """
      |@SP
      |AM=M-1
      |D=!M
      |M=D
      |@SP
      |M=M+1
      |""".stripMargin

  val AND: String =
    """
      |@SP
      |AM=M-1
      |D=M
      |@SP
      |AM=M-1
      |D=D&M
      |M=D
      |@SP
      |M=M+1
      |""".stripMargin

  val OR: String =
    """
      |@SP
      |AM=M-1
      |D=D|M
      |M=D
      |@SP
      |M=M+1
      |""".stripMargin

  val NEG: String =
    """
      |@SP
      |AM=M-1
      |D=-M
      |M=D
      |@SP
      |M=M+1
      |""".stripMargin

  val EQ: String =
    """
      |@SP
      |AM=M-1
      |D=M
      |@SP
      |AM=M-1
      |D=M-D
      |@EQ.{index}_TRUE
      |D;JEQ
      |@SP
      |A=M
      |M=0
      |@EQ.{index}_END
      |0;JMP
      |(EQ.{index}_TRUE)
      |@SP
      |A=M
      |M=-1
      |EQ.{index}_END)
      |@SP
      |M=M+1
      |""".stripMargin

  val GT: String =
    """
      |@SP
      |AM=M-1
      |D=M
      |@SP
      |AM=M-1
      |D=M-D
      |@GT.{index}_TRUE
      |D;JGT
      |@SP
      |A=M
      |M=0
      |@GT.{index}_END
      |0;JMP
      |(GT.{index}_TRUE)
      |@SP
      |A=M
      |M=-1
      |(LT.{index}_END)
      |@SP
      |M=M+1
      |""".stripMargin

  val LT: String =
    """
      |@SP
      |AM=M-1
      |D=M
      |@SP
      |AM=M-1
      |D=M-D
      |@LT.{index}_TRUE
      |D;JLT
      |@SP
      |A=M
      |M=0
      |@LT.{index}_END
      |0;JMP
      |(LT.{index}_TRUE)
      |@SP
      |A=M
      |M=-1
      |(LT.{index}_END)
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

