package v.shinkevich.stockmarket

import org.scalatest.FunSuite
import org.scalatest.Matchers._
import v.shinkevich.stockmarket.io.OrdersTextReader
import v.shinkevich.stockmarket.model.Order

class OrdersTextReaderTest extends FunSuite {

  test("Load Orders file") {
    val orders = new OrdersTextReader("tz/orders.txt").readOrders()

    orders.size shouldBe 8070

    orders(0) shouldBe Order("C8", "b", "C", 15, 4)
    orders(8069) shouldBe Order("C9", "b", "D", 4, 3)
  }

}
