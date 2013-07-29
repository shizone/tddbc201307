sealed trait Money
sealed trait UsableMoney extends Money

case object Coin10 extends UsableMoney
case object Coin50 extends UsableMoney
case object Coin100 extends UsableMoney
case object Coin500 extends UsableMoney
case object Bill1000 extends UsableMoney

case object Coin1 extends Money
case object Coin5 extends Money
case object Bill2000 extends Money
case object Bill5000 extends Money
case object Bill10000 extends Money

object Money {

  implicit class RichMoney(val money: Money) extends AnyVal {

    def value = money match {
      case Coin1 => 1
      case Coin5 => 5
      case Coin10 => 10
      case Coin50 => 50
      case Coin100 => 100
      case Coin500 => 500
      case Bill1000 => 1000
      case Bill2000 => 2000
      case Bill5000 => 5000
      case Bill10000 => 10000
    }
  }
}