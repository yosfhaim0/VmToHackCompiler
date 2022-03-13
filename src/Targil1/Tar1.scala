package Targil1

import java.io.{File, FileWriter}

object Tar1 {

  def main(args: Array[String]): Unit = {
    val p = new Parser(new File("C:\\Users\\yosef\\IdeaProjects\\VmToHackCompiler\\src\\Targil1\\StackArithmetic\\SimpleAdd\\SimpleAdd.vm"))
    val c = new CodeWriter(new FileWriter("SimpleAdd.asm", false))
    while p.hasMoreCommands() do
      p.advance()
      var a=p.CommandType()
      if p.CommandType() == Constants.CommandType.C_POP||p.CommandType() == Constants.CommandType.C_PUSH then
        c.WritePushPop(p.CommandType(),p.arg1(),p.arg2())
      else if p.CommandType() == Constants.CommandType.C_ARITHMETIC then
        c.WriteArithmetic(p.arg1())
      end if
      c.close()


//    val CW = CodeWriter
//    print(CW.WritePushPop("C_POP", "local", 3))
//    print(CW.WritePushPop("C_POP", "pointer", 1))
//    print(CW.WritePushPop("C_POP", "pointer", 0))
//    print(CW.WritePushPop("C_POP", "temp", 3))
//    print(CW.WritePushPop("C_POP", "this", 5))
//    print(CW.WritePushPop("C_POP", "static", 4))
//    print(CW.WritePushPop("C_POP", "argument", 21))
//
//    print(CW.WritePushPop("C_PUSH", "local", 3))
//    print(CW.WritePushPop("C_PUSH", "pointer", 1))
//    print(CW.WritePushPop("C_PUSH", "pointer", 0))
//    print(CW.WritePushPop("C_PUSH", "temp", 3))
//    print(CW.WritePushPop("C_PUSH", "this", 5))
//    print(CW.WritePushPop("C_PUSH", "static", 4))
//    print(CW.WritePushPop("C_PUSH", "argument", 21))

  }
}
