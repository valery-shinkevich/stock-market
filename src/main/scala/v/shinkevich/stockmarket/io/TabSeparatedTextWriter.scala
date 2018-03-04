package v.shinkevich.stockmarket.io

abstract class TabSeparatedTextWriter(val fileName: String) {

  private def printToFile(f: java.io.File)(op: java.io.PrintWriter => Unit) {
    val p = new java.io.PrintWriter(f)
    try {
      op(p)
    } finally {
      p.flush()
      p.close()
    }
  }

  def writeValues(values: Seq[Seq[Any]]): Unit = {
    import java.io.File

    val file = new File(fileName)

    if (file.exists()) file.delete()

    printToFile(file) {
      p =>
        values.foreach(
          v => p.println(v.mkString("\t"))
        )
    }
  }
}
