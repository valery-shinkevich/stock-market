package v.shinkevich.stockmarket

import org.scalatest.FunSuite
import org.scalatest.Matchers._
import v.shinkevich.stockmarket.io.ClientsTextReader
import v.shinkevich.stockmarket.model.Client


class ClientsTextReaderTest extends FunSuite {

  test("Load Clients file") {
    val clients = new ClientsTextReader("tz/clients.txt").readClients()

    clients.size shouldBe 9

    clients(0) shouldBe Client("C1", 1000, 130, 240, 760, 320)
    clients(8) shouldBe Client("C9", 7250, 190, 190, 0, 280)
  }

}


