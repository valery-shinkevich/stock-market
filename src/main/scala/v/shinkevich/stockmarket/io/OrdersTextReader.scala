package v.shinkevich.stockmarket.io

import v.shinkevich.stockmarket.model.Order

import scala.io.Source

class OrdersTextReader(val fileName: String) {

  def readOrders(): Seq[Order] = {
    for {
      line <- Source.fromFile(name = fileName).getLines().toVector
      values = line.split('\t').map(_.trim)
    }
      yield Order(values)
  }

}
