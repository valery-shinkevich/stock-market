package v.shinkevich.stockmarket.io

import v.shinkevich.stockmarket.model.Client

import scala.io.Source

class ClientsTextReader(val fileName: String) {

  def readClients(): Seq[Client] = {
    for {
      line <- Source.fromFile(name = fileName).getLines().toVector
      values = line.split('\t').map(_.trim)
    }
      yield Client(values)
  }
}


