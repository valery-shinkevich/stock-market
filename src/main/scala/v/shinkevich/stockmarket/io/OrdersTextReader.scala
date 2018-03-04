package v.shinkevich.stockmarket.io

import v.shinkevich.stockmarket.model.Order

class OrdersTextReader(fileName: String) extends TabSeparatedTextReader(fileName) {

  private def createOrder(values: Seq[String]): Order = Order(
    clientName = values.head,
    operation = values(1),
    stock = values(2),
    price = values(3).toInt,
    quantity = values(4).toInt
  )

  def read: Seq[Order] = {
    for (values <- readValues)
      yield createOrder(values)
  }
}
