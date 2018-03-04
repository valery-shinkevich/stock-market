package v.shinkevich.stockmarket.io

import v.shinkevich.stockmarket.model.Client

class ClientsTextReader(fileName: String) extends TabSeparatedTextReader(fileName) {

  private def createClient(values: Seq[String]): Client = Client(
    clientName = values.head,
    cash = values(1).toInt,
    balanceA = values(2).toInt,
    balanceB = values(3).toInt,
    balanceC = values(4).toInt,
    balanceD = values(5).toInt
  )

  def read: Seq[Client] = {

    for (values <- readValues) yield createClient(values)

  }
}


