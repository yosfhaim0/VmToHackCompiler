package Targil0

// Targil 0 in Principles of software languages
// present:
// Yosef Haim Amrusi 314897208
// Aharon Kremer 034706382

import scala.io._
import java.io._
import scala.util.Using


object main {

  // global variable for sell calc
  var sumSell: Float = 0

  // global variable for buy calc
  var sumBuy: Float = 0

  // ASM file for writing
  var AsmFile: FileWriter = _


  def SelectAllVMFiles(path: String): Array[File] = {
    new File(path).listFiles.filter(_.getName.endsWith(".vm"))
  }

  def CreateASMFile(path: String): FileWriter = {
    // reach last folder name in path
    val file_Object = path.substring(path.lastIndexOf('\\') + 1)
    new FileWriter(file_Object + ".asm", false)
  }

  def WriteHeader2Asm(path2VM: String): Unit = {
    AsmFile.write(path2VM.substring(path2VM.lastIndexOf('\\') + 1).stripSuffix(".vm") + "\n")
  }

  def WriteContent2Asm(VM: File): Unit = {
    Using(Source.fromFile(VM)) { reader =>
      reader.getLines().foreach { line =>

        val lexInLine = line.split(" ")

        if (lexInLine(0) == "buy")
          HandleBuy(lexInLine(1), lexInLine(2).toInt, lexInLine(3).toFloat)

        else
          HandleSell(lexInLine(1), lexInLine(2).toInt, lexInLine(3).toFloat)
      }
    }
  }

  def WriteSum2ASM(): Unit = {
    AsmFile.write("TOTAL BUY: " + sumBuy.toString + "\nTOTAL SELL: " + sumSell.toString)
  }

  def WriteFromVM2Asm(VMFiles: Array[File]): Unit = {

    VMFiles.foreach { VM =>
      // Write header from VM to ASM
      WriteHeader2Asm(VM.toString)
      // write content from VM to ASM (by some logic)
      WriteContent2Asm(VM)
    }

    // Write summary of buys and sells to ASM
    WriteSum2ASM()

  }

  def main(args: Array[String]): Unit = {

    print("Input path: ")
    val path = scala.io.StdIn.readLine()

    // Select all VM files from path
    val vmFiles = SelectAllVMFiles(path)

    // Create ASM file for writing, name of file as name of last folder in path
    AsmFile = CreateASMFile(path)

    // Write from VM files to ASM file
    WriteFromVM2Asm(vmFiles)

    AsmFile.close()

    // print summary to screen
    print("TOTAL BUY: " + sumBuy.toString + "\nTOTAL SELL: " + sumSell.toString)
  }

  def HandleBuy(ProductName: String, Amount: Int, Price: Float): Unit = {

    AsmFile.write("$$$ BUY " + ProductName + " $$$\n")
    sumBuy = Amount * Price + sumBuy
    AsmFile.write((Amount * Price).toString + '\n')

  }

  def HandleSell(ProductName: String, Amount: Int, Price: Float): Unit = {

    AsmFile.write("$$$ SELL " + ProductName + " $$$\n")
    sumSell = Amount * Price + sumSell
    AsmFile.write((Amount * Price).toString + '\n')

  }
}


/*
%%%%%%%%%%%%%%%%%%%%%%%input%%%%%%%%%%%%%%%%%%%%%%%%
Please enter inputIndex path:
C:\Users\yosef\IdeaProjects\targil0
%%%%%%%%%%%%%%%%%%%%%%%output%%%%%%%%%%%%%%%%%%%%%%%
InputA
$$$ BUY bread $$$
13.5
$$$ BUY cheese $$$
10.6
$$$ SELL cheese $$$
85.5
$$$ BUY milk $$$
24.8
$$$ SELL chocolate $$$
71.4
$$$ BUY milk $$$
22.4
$$$ SELL chocolate $$$
11.0
InputB
$$$ BUY chocolate $$$
12.5
$$$ SELL eggs $$$
621.0
$$$ BUY cheese $$$
10.6
$$$ SELL sugar $$$
82.5
$$$ SELL flour $$$
25.199999
$$$ BUY milk $$$
11.1
TOTAL BUY: 105.5
TOTAL SELL: 896.60004
*/