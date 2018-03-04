package v.shinkevich.stockmarket.io

import v.shinkevich.stockmarket.model.Client

class ClientsTextWriter(fileName: String) extends TabSeparatedTextWriter(fileName) {

  private def toSeqOfValues(client:Client): Seq[Any] = Seq(
    client.clientName,
    client.cash,
    client.balanceA,
    client.balanceB,
    client.balanceC,
    client.balanceD
  )

  def write(clients: Seq[Client]) :Unit = {
    writeValues(
      clients
      .sortBy(_.clientName)
      .map(c=> toSeqOfValues(c))
    )
  }
}
