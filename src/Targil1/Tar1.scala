package Targil1

import java.io.File

object Tar1 {

  def main(args: Array[String]) = {

    val path = "xxx"
    val file = new File(path)
    val c = new CodeWriter(file: File)

    //for (command <- Constants.CommandType.values) println(command.toString)
    println(Constants.Push_Constant)
  }


}
