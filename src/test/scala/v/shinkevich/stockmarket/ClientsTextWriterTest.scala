package v.shinkevich.stockmarket

import java.io.File

import org.scalatest.FunSuite
import org.scalatest.Matchers._
import v.shinkevich.stockmarket.io.ClientsTextWriter
import v.shinkevich.stockmarket.model.Client

import scala.io.Source

class ClientsTextWriterTest extends FunSuite {

  val tempFileName = "tz/temp_result.txt"

  test("Write Clients to temp file") {

    val clients = Seq(
      Client("C9", 7250, 190, 190, 0, 280),
      Client("C1", 1000, 130, 240, 760, 320)
    )

    val writer = new ClientsTextWriter(tempFileName)
    writer.writeClients(clients)

    val lines = Source.fromFile(name = tempFileName).getLines().toSeq

    val file = new File(tempFileName)
    if (file.exists()) file.delete()

    lines.size shouldBe 2

    lines(0) shouldBe """C1	1000	130	240	760	320"""
    lines(1) shouldBe """C9	7250	190	190	0	280"""
  }
}
