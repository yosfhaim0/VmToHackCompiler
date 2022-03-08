package Targil1

object Constants {

  object CommandType extends Enumeration {
    type CommandType = Value
    val C_ARITHMETIC, C_PUSH, C_POP, C_LABEL, C_GOTO, C_IF, C_FUNCTION, C_RETURN, C_CALL = Value
  }

  val Push_Constant: String =
    """|@{value}
       |D=A
       |@SP
       |A=M
       |M=D
       |@SP
       |M=M+1
       |""".stripMargin

  // val Pop


}

