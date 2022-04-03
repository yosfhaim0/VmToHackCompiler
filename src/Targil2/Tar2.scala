package Targil2

import java.io.{File, FileWriter}
import java.util

object Tar2 {

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
    //System.getProperty("user.dir")
    val paths = getListOfVmStringFiles(args(0).toString())
    for (path <- paths) {

      val p = new Parser(new File(path))
      val file_Name = path.substring(0, path.lastIndexOf('.'))
      val c = new CodeWriter(new FileWriter(file_Name + ".asm", false), file_Name.substring(file_Name.lastIndexOf('\\') + 1))
      while (p.hasMoreCommands()) {
        p.advance()
        var a = p.CommandType()
        if (p.CommandType() == Constants.CommandType.C_POP || p.CommandType() == Constants.CommandType.C_PUSH)
          c.WritePushPop(p.CommandType(), p.arg1(), p.arg2())
        else if (p.CommandType() == Constants.CommandType.C_ARITHMETIC)
          c.WriteArithmetic(p.arg1())
        else if (p.CommandType() == Constants.CommandType.C_LABEL) {
          c.WriteLabel(p.arg1())
        }
        else if (p.CommandType() == Constants.CommandType.C_GOTO) {
          c.WriteGoto(p.arg1())
        }
        else if (p.CommandType() == Constants.CommandType.C_IFGOTO) {
          c.WriteIfGoto(p.arg1())
        }
        else if (p.CommandType()==Constants.CommandType.C_CALL){
          c.WriteCall(p.arg1(),p.arg2())
        }
        else if (p.CommandType()==Constants.CommandType.C_RETURN){
          c.WriteReturn()
        }
        else if (p.CommandType()==Constants.CommandType.C_FUNCTION){
          c.WriteFunction(p.arg1(),p.arg2())
        }


     }
      c.close()
    }

  }
}
