package Targil1

import java.io.{File, FileWriter}

object Tar1 {

  def main(args: Array[String]): Unit = {

    // Create ASM file for writing, name of file as name of last folder in path
    var asmFile: FileWriter =  new FileWriter("test.asm", false)

    // ASM file for writing
    val CW = CodeWriter(asmFile)
    CW.setFileName(asmFile.toString)
    CW.WritePushPop("C_POP", "local", 3)
    CW.WritePushPop("C_POP", "pointer", 1)
    CW.WritePushPop("C_POP", "pointer", 0)
    CW.WritePushPop("C_POP", "temp", 3)
    CW.WritePushPop("C_POP", "this", 5)
    CW.WritePushPop("C_POP", "static", 4)
    CW.WritePushPop("C_POP", "argument", 21)

    CW.WritePushPop("C_PUSH", "local", 3)
    CW.WritePushPop("C_PUSH", "pointer", 1)
    CW.WritePushPop("C_PUSH", "pointer", 0)
    CW.WritePushPop("C_PUSH", "temp", 3)
    CW.WritePushPop("C_PUSH", "this", 5)
    CW.WritePushPop("C_PUSH", "static", 4)
    CW.WritePushPop("C_PUSH", "argument", 21)

    CW.close()
    //val p = Parser
    //val command = "push constant 7"

  }
}
