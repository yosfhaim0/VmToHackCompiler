package Targil1

import java.io.File

object Tar1 {

  def main(args: Array[String]): Unit = {

    val CW = CodeWriter
    print(CW.WritePushPop("C_POP", "local", 3))
    print(CW.WritePushPop("C_POP", "pointer", 1))
    print(CW.WritePushPop("C_POP", "pointer", 0))
    print(CW.WritePushPop("C_POP", "temp", 3))
    print(CW.WritePushPop("C_POP", "this", 5))
    print(CW.WritePushPop("C_POP", "static", 4))
    print(CW.WritePushPop("C_POP", "argument", 21))

    print(CW.WritePushPop("C_PUSH", "local", 3))
    print(CW.WritePushPop("C_PUSH", "pointer", 1))
    print(CW.WritePushPop("C_PUSH", "pointer", 0))
    print(CW.WritePushPop("C_PUSH", "temp", 3))
    print(CW.WritePushPop("C_PUSH", "this", 5))
    print(CW.WritePushPop("C_PUSH", "static", 4))
    print(CW.WritePushPop("C_PUSH", "argument", 21))

  }
}
