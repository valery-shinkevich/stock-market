package v.shinkevich.stockmarket.model

/*
  Имя клиента
  Баланс клиента по долларам
  Баланс клиента по ценной бумаге "A" в штуках
  Баланс по ценной бумаге "B"
  Баланс по ценной бумаге "C"
  Баланс по ценной бумаге "D"
*/
case class Client(clientName: String, cash: Int, balanceA: Int, balanceB: Int, balanceC: Int, balanceD: Int) {
}

object Client {
  def apply(values: Seq[String]): Client = Client(
    clientName = values.head,
    cash = values(1).toInt,
    balanceA = values(2).toInt,
    balanceB = values(3).toInt,
    balanceC = values(4).toInt,
    balanceD = values(5).toInt
  )
}
