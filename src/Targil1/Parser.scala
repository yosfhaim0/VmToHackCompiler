package Targil1

import scala.io._
import java.io._
import scala.util.Using

/**
 *
 */
class Parser(inputFile: File) {

  //current command
  var CurCommand: String = _

  val fileLines = io.Source.fromFile(inputFile).getLines()


  def hasMoreCommands(): Boolean = { //TODO
    return !fileLines.isEmpty
  }

  def advance(): Unit = {
    CurCommand = fileLines.next()
    while ((CurCommand.startsWith("//") || CurCommand.isEmpty) && hasMoreCommands())
      CurCommand = fileLines.next()
  }


  def CommandType(): String = {
    val arg0 = (CurCommand.split(" ")) (0)
    arg0 match {
      case "push" => Constants.CommandType.C_PUSH
      case "pop" => Constants.CommandType.C_POP
      case "add" | "sub" | "neg" | "eq" | "gt" | "lt" | "and" | "or" | "not" => Constants.CommandType.C_ARITHMETIC
      case _ => Constants.CommandType.C_NOTHING
    }
  }

  def arg1(): String = {
    var arg1 = ""
    if (CommandType() != Constants.CommandType.C_POP && CommandType() != Constants.CommandType.C_PUSH)
      arg1=CurCommand.split(" ")(0)
    else
      arg1=CurCommand.split(" ")(1)
    return arg1
  }

  def arg2(): Int = {
    CurCommand.split(" ")(2).toInt
  }

}
