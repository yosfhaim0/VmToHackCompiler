package Targil2

import java.io.{File, FileWriter}
import java.util

object Tar2 {

  def getListOfVmFiles(root: String): Unit = {

    val d = new File(root)

    if (d.listFiles.filter(_.isDirectory).toList.isEmpty) {
      val ret = d.listFiles.filter(_.isFile).toList.filter(p => p.toString.endsWith(".vm"))
      if (!ret.isEmpty) {
        if (ret.size > 1) {
          handleManyFile(ret.map(p => p.toString),d.toString)
        } else {
          handelOneFile(ret(0).toString())
        }

      }
      return
    }

    var vms: List[File] = d.listFiles.filter(_.isFile).toList.filter(p => p.toString.endsWith(".vm"))
    if (!vms.isEmpty) {
      if (vms.size > 1) {
        handleManyFile(vms.map(p => p.toString),d.toString)
      } else {
        handelOneFile(vms(0).toString())
      }
    }
    val dirs: List[File] = d.listFiles.filter(_.isDirectory).toList
    for (dir <- dirs) {
      getListOfVmFiles(dir.toString)
    }
  }

  def main(args: Array[String]): Unit = {
    //System.getProperty("user.dir")
    val paths = getListOfVmFiles(args(0).toString())

  }

  def handelOneFile(path: String): Unit = {
    val p = new Parser(new File(path))
    val file_Path = path.substring(0, path.lastIndexOf('\\'))
    val file_Name=file_Path.substring(0,file_Path.lastIndexOf("\\"))
    val g=path.substring(file_Name.length,file_Path.length)
    val c = new CodeWriter(new FileWriter(file_Path+ g +".asm", false), g.substring(1,g.length))
    generatAsembley(p, c)
    c.close()
  }

  def handleManyFile(paths: List[String],d:String): Unit = {
    val dicName=d.substring(d.lastIndexOf('\\') + 1)
    val file_Name = d.substring(0, d.length)
    var x=file_Name.substring(file_Name.lastIndexOf('\\') + 1)
    val c = new CodeWriter(new FileWriter(file_Name+s"\\$dicName" + ".asm", false),x )
    c.WriteBootStraping()
    for (path <- paths) {
      val p = new Parser(new File(path))
      c.setFileName(path.substring(path.lastIndexOf("\\")+1,path.lastIndexOf(".")))
      generatAsembley(p, c)
    }
    c.close()
  }

  def generatAsembley(p: Parser, c: CodeWriter): Unit = {
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
      else if (p.CommandType() == Constants.CommandType.C_CALL) {
        c.WriteCall(p.arg1(), p.arg2())
      }
      else if (p.CommandType() == Constants.CommandType.C_RETURN) {
        c.WriteReturn()
      }
      else if (p.CommandType() == Constants.CommandType.C_FUNCTION) {
        c.WriteFunction(p.arg1(), p.arg2())
      }


    }
  }
}
