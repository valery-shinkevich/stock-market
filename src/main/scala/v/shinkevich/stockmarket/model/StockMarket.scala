package v.shinkevich.stockmarket.model

class StockMarket(val clients: Seq[Client], val orders: Seq[Order]) {

  def calculateStocks(): Seq[Client] = {

    orders.map(o => {

      val cashModifier = o.operation match {
        case "b" => -o.quantity * o.price
        case "s" => o.quantity * o.price
      }

      val quantityModifier = o.operation match {
        case "b" => o.quantity
        case "s" => -o.quantity
      }

      Client(
        clientName = o.clientName,
        cash = cashModifier,
        balanceA = if (o.stock == "A") quantityModifier else 0,
        balanceB = if (o.stock == "B") quantityModifier else 0,
        balanceC = if (o.stock == "C") quantityModifier else 0,
        balanceD = if (o.stock == "D") quantityModifier else 0
      )
    })
      .union(clients)
      .groupBy(c => c.clientName)
      .mapValues(c =>
        Client(
          clientName = c.head.clientName,
          cash = c.map(_.cash).sum,
          balanceA = c.map(_.balanceA).sum,
          balanceB = c.map(_.balanceB).sum,
          balanceC = c.map(_.balanceC).sum,
          balanceD = c.map(_.balanceD).sum)
      ).values.toSeq
  }
}
