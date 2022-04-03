package Targil2

import Targil1.Constants.MemAccCmd._
import Targil1.Constants._

import java.io._

class CodeWriter(asmFile: FileWriter, File_Name: String) {
  var counter: Int = 0
  var callCounter: Int = 0
  var currentFileName: String = File_Name

  def close(): Unit = {
    asmFile.close()
  }

  def setFileName(fileName: String) = {
    currentFileName=fileName
  }

  def increment(): Unit = {
    counter = counter + 1
  }

  def callCounterIncrement(): Unit = {
    callCounter = callCounter + 1
  }

  def WriteArithmetic(command: String): Unit = {
    val toWrite: String =
      command match {
        case ArithmeticCmd.ADD => ADD
        case ArithmeticCmd.SUB => SUB
        case ArithmeticCmd.NEG => NEG
        case ArithmeticCmd.EQ => {
          increment()
          EQ.replaceAll("val", counter.toString)
        }
        case ArithmeticCmd.GT => {
          increment()
          GT.replaceAll("val", counter.toString)
        }
        case ArithmeticCmd.LT => {
          increment()
          LT.replaceAll("val", counter.toString)
        }
        case ArithmeticCmd.AND => AND
        case ArithmeticCmd.OR => OR
        case ArithmeticCmd.NOT => NOT
      }
    asmFile.write(toWrite)
  }

  def tran(segment: String): String = {
    segment match {
      case "local" => "LCL"
      case "argument" => "ARG"
      case "this" => "THIS"
      case "that" => "THAT"
      case _ => segment
    }
  }

  def WritePushPop(command: String, segment: String, index: Int): Unit = {
    val seg = tran(segment)
    val toWrite: String =
      command match {
        case CommandType.C_PUSH =>
          seg match {
            case LCL | ARG | THIS | THAT => BuildPushRam(PUSH_LCL_ARG_THIS_THAT, index, seg)
            case PTR => BuildAll(PUSH_POINTER, index)
            case TMP => BuildAll(PUSH_TEMP, index)
            case CONST => BuildAll(PUSH_CONSTANT, index)
            case STAT => BuildAll(PUSH_STATIC, index)
          }
        case CommandType.C_POP =>
          seg match {
            case LCL | ARG | THIS | THAT => BuildPopRam(POP_LCL_ARG_THIS_THAT, index, seg)
            case PTR => BuildPopPtr(POP_POINTER, index)
            case TMP => BuildAll(POP_TEMP, index)
            case CONST => BuildAll(POP_CONSTANT, index)
            case STAT => BuildAll(POP_STATIC, index)
          }
      }
    asmFile.write(toWrite)
  }

  private def BuildPushRam(asmCmd: String, index: Int, segment: String): String = {
    asmCmd
      .replace("{segment}", segment)
      .replace("{index}", index.toString)
  }

  private def BuildAll(asmCmd: String, index: Int): String = {
    asmCmd
      .replace("{index}", index.toString)
  }

  private def BuildPopRam(asmCmd: String, index: Int, segment: String): String = {
    var toAdd: String = ""
    for (_ <- 1 to index) {
      toAdd += "\nA=A+1"
    }
    asmCmd
      .replace("{segment}", segment)
      .replace("`+index", toAdd)
  }

  private def BuildPopPtr(asmCmd: String, index: Int): String = {
    var toAdd: String = ""
    for (_ <- 1 to index) {
      toAdd += "\nA=A+1"
    }
    asmCmd
      .replace("`+index", toAdd)
  }

  def WriteLabel(label: String): Unit = {
    asmFile.write(Constants.LABEL.replace("FileName.c",
      s"$currentFileName.$label"))
  }

  def WriteGoto(label: String): Unit = {
    asmFile.write(Constants.GOTO.replace("FileName.c",
      s"$currentFileName.$label"))
  }

  def WriteIfGoto(label: String): Unit = {
    asmFile.write(Constants.IFGOTO
      .replace("FileName.c", s"$currentFileName.$label"))
  }

  def WriteCall(functionName: String, numOfArgument: Int): Unit = {
    asmFile.write(Constants.CALL
      .replace("NameOfFunc", s"$functionName")
      .replace("numARG", s"$numOfArgument")
      .replace("index", s"$callCounter"))
    callCounterIncrement()
  }

  def WriteReturn(): Unit = {
    asmFile.write(Constants.RETURN)
  }

  def WriteFunction(NameOfFunc: String, numOfLocal: Int): Unit = {
    asmFile.write(Constants.FUNCTION
      .replace("NameOfFunc", s"$NameOfFunc")
      .replace("NumOfLocal", s"$numOfLocal"))
  }

  def WriteBootStraping(): Unit = {
    asmFile.write(Constants.BOOTSTRAPPING)
  }


}
