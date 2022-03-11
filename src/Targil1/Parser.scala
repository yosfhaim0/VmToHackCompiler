package Targil1

import scala.io._
import java.io._
import scala.util.Using

/**
 *
 */
object Parser {
  // ASM file for writing
  var VMFile: File = _
  //current command
  var CurCommand: String = _

  def parser(inputFile: File): Unit = {
    VMFile = inputFile
  }

  def setCurCommand(Command: String): Unit = {
    CurCommand = Command
  }

  def hasMoreCommands(): Boolean = { //TODO
    return true
  }

  def getCommandType(): Unit = {
    val a = (CurCommand.split(" ")) (0)
    a match {
      case "push" => Constants.CommandType.C_PUSH
      case "pop" => Constants.CommandType.C_POP
      case "add" | "sub" | "neg" | "eq" | "gt" | "lt" | "and" | "or" | "not" => Constants.CommandType.C_ARITHMETIC
      case _ => Constants.CommandType.C_NOTHING
    }
  }

  def arg1(): String = {
    CurCommand.split(" ")(1)
  }

  def arg2(): String = {
    CurCommand.split(" ")(2)
  }


}
