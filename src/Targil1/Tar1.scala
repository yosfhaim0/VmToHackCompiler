package Targil1

import java.io.{File, FileWriter}
import java.util

object Tar1 {

  def getListOfVmFiles(root: String): List[File] = {

    val d = new File(root)

    if (d.listFiles.filter(_.isDirectory).toList.isEmpty) {
      val ret = d.listFiles.filter(_.isFile).toList.filter(p => p.toString.endsWith(".vm"))
      return ret
    }

    var vms: List[File] = d.listFiles.filter(_.isFile).toList.filter(p => p.toString.endsWith(".vm"))
    val dirs: List[File] = d.listFiles.filter(_.isDirectory).toList
    for (dir <- dirs) {
      vms = vms ::: getListOfVmFiles(dir.toString)
    }
    vms
  }

  def getListOfVmStringFiles(path: String) = {
    getListOfVmFiles(path).map(path => path.toString)
  }

  def main(args: Array[String]): Unit = {

    val paths = getListOfVmStringFiles(System.getProperty("user.dir") + "\\src")
    for (path <- paths) {
      val p = new Parser(new File(path))
      val file_Object = path.substring(0, path.lastIndexOf('.'))
      val c = new CodeWriter(new FileWriter(file_Object + ".asm", false))
      while (p.hasMoreCommands()) {
        p.advance()
        var a = p.CommandType()
        if (p.CommandType() == Constants.CommandType.C_POP || p.CommandType() == Constants.CommandType.C_PUSH)
          c.WritePushPop(p.CommandType(), p.arg1(), p.arg2())
        else if (p.CommandType() == Constants.CommandType.C_ARITHMETIC)
          c.WriteArithmetic(p.arg1())
      }
      c.close()
    }


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
