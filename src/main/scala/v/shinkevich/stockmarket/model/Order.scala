package v.shinkevich.stockmarket.model

/*
  Имя клиента выставившего заявку
  Символ операции: "s" - продажа или "b" - покупка.
  Наименование ценной бумаги
  Цена заявки (целое число за одну штуку ценной бумаги)
  Количество продаваемых или покупаемых ценных бумаг
*/

case class Order(clientName: String, operation: String, stock: String, price: Int, quantity: Int)

object Order {
  def apply(values: Seq[String]): Order = Order(
    clientName = values.head,
    operation = values(1),
    stock = values(2),
    price = values(3).toInt,
    quantity = values(4).toInt
  )
}
