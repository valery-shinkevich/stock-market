package v.shinkevich.stockmarket.io

import scala.io.Source

abstract class TabSeparatedTextReader(fileName: String) {

 protected def readValues: Seq[Array[String]] = {
   for {
     line <- Source.fromFile(name = fileName).getLines().toVector
     values = line.split('\t').map(_.trim)
   }
     yield values
 }

}
