package v.shinkevich.stockmarket

import org.scalatest.FunSuite
import org.scalatest.Matchers._
import v.shinkevich.stockmarket.model.{Client, Order, StockMarket}


class StockMarketTest extends FunSuite {

  test("StockMarket calculation") {

    val clients = Seq(
      Client(clientName = "C1", cash = 1000, balanceA = 130, balanceB = 240, balanceC = 760, balanceD = 320),
      Client(clientName = "C9", cash = 7250, balanceA = 190, balanceB = 190, balanceC = 0, balanceD = 280)
    )

    val orders = Seq(
      Order(clientName = "C1", operation = "s", stock = "C", price = 10, quantity = 60),
      Order(clientName = "C1", operation = "b", stock = "A", price = 1, quantity = 30),
      Order(clientName = "C9", operation = "b", stock = "D", price = 5, quantity = 3)
    )

    val market = new StockMarket(clients, orders)

    val results = market.calculateStocks().sortBy(_.clientName)


    results(0) shouldBe Client(clientName = "C1", cash = 1570, balanceA = 160, balanceB = 240, balanceC = 700, balanceD = 320)
    results(1) shouldBe Client(clientName = "C9", cash = 7235, balanceA = 190, balanceB = 190, balanceC = 0, balanceD = 283)

  }
}


