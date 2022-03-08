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

  def hasMoreCommands(): Boolean = {
    return true
  }

  def getCommandType(): Unit = {
    val a = (CurCommand.split(" ")) (0)
    a match {
      case "push" =>
    }
  }

  def arg1(): String = {
    CurCommand.split(" ")(1)
  }

  def arg2(): String = {
    CurCommand.split(" ")(2)
  }


}
