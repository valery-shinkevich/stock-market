package v.shinkevich.stockmarket

import org.log4s.{Logger, getLogger}
import v.shinkevich.stockmarket.io.{ClientsTextReader, ClientsTextWriter, OrdersTextReader}
import v.shinkevich.stockmarket.model.StockMarket

object StockMarketApplication {

  val log: Logger = getLogger

  def main(args: Array[String]): Unit = {

    val clients = new ClientsTextReader("tz/clients.txt").readClients()
    log.info(s"Загружено ${clients.size} клиентов")

    val orders = new OrdersTextReader("tz/orders.txt").readOrders()
    log.info(s"Загружено ${orders.size} ордеров")

    val result = new StockMarket(clients, orders).calculateStocks()

    val outputFileName = s"tz/result.txt"

    val writer = new ClientsTextWriter(outputFileName)
    writer.writeClients(result)
    log.info(s"Результат записан в $outputFileName")

  }
}
