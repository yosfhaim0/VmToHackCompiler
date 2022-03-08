package Targil1

object Constants {

  object CommandType extends Enumeration {
    type CommandType = Value
    val C_ARITHMETIC, C_PUSH, C_POP, C_LABEL, C_GOTO, C_IF, C_FUNCTION, C_RETURN, C_CALL = Value
  }

  /**
   *            //  EXAMPLE: vm command: ADD
   *     @SP    //  A = 0
   *     A=M-1  //  A = RAM[A]-1 = RAM[0]-1 = 258-1 = 257 => A=257
   *     D=M		//  D = RAM[A] = RAM[257] = 5
   *            //  D saves the second item in the stack
   *     A=A-1	//  A = 257-1 = 256
   *     M=D+M	//  RAM[A] = D+RAM[A] => RAM[256] = 5+RAM[256] = 5+4 = 9
   *            //  save the add result in the place of the first item on the stack
   *            //  this is equal to:  pop second item, pop first item,
   *            //  push the result of their addition to the stack.
   *     @SP    //  after pushing the result to the stack,
   *            //  we want to decrement the stack pointer.
   *            //  current command is: A=0
   *     M=M-1	//  RAM[A] = RAM[A]-1
   *            //  => RAM[0] = RAM[0] - 1
   *            //  => RAM[0] = 258-1 = 257.
   *            //  so now the stack pointer, saved in RAM[0], points to RAM[257]
   */
  val Add: String =
    """|@SP
       |A=M-1
       |D=M
       |A=A-1
       |M=D+M
       |@SP
       |M=M-1
       |""".stripMargin

  val Sub: String =
    """|@SP
       |A=M-1
       |D=M
       |A=A-1
       |M=D-M
       |@SP
       |M=M-1
       |""".stripMargin

  val Push_Constant: String =
    """|@{value}
       |D=A
       |@SP
       |A=M
       |M=D
       |@SP
       |M=M+1
       |""".stripMargin




  val Pop_Constant: String =
    """|@{value}
       |D=A
       |@SP
       |A=M
       |M=D
       |@SP
       |M=M+1
       |""".stripMargin

  /* val Push_Constant: String =
     """|@{value}
        |D=A
        |@SP
        |A=M
        |M=D
        |@SP
        |M=M+1
        |""".stripMargin

   val Push_Constant: String =
     """|@{value}
        |D=A
        |@SP
        |A=M
        |M=D
        |@SP
        |M=M+1
        |""".stripMargin

   */


  // val Pop


}

