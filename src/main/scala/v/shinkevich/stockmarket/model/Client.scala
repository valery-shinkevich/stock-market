package v.shinkevich.stockmarket.model

/*
  Имя клиента
  Баланс клиента по долларам
  Баланс клиента по ценной бумаге "A" в штуках
  Баланс по ценной бумаге "B"
  Баланс по ценной бумаге "C"
  Баланс по ценной бумаге "D"
*/
case class Client(clientName: String, cash: Int, balanceA: Int, balanceB: Int, balanceC: Int, balanceD: Int)