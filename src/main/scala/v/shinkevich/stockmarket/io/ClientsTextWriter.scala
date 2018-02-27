package v.shinkevich.stockmarket.io

import v.shinkevich.stockmarket.model.Client

class ClientsTextWriter(val fileName: String) {

  private def printToFile(f: java.io.File)(op: java.io.PrintWriter => Unit) {
    val p = new java.io.PrintWriter(f)
    try {
      op(p)
    } finally {
      p.flush()
      p.close()
    }
  }

  def writeClients(clients: Seq[Client]): Unit = {

    import java.io.File

    val file = new File(fileName)

    if (file.exists()) file.delete()

    printToFile(file) {
      p =>
        clients
          .sortBy(_.clientName)
          .foreach(c => p.println(s"${c.clientName}\t${c.cash}\t${c.balanceA}\t${c.balanceB}\t${c.balanceC}\t${c.balanceD}"))
    }

  }

}
