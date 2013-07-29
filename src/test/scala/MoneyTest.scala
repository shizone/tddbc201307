import org.scalatest.FunSuite

class MoneyTest extends FunSuite{

  test ("お金オブジェクトが使える") {
    assert(Coin10 === Coin10)
    assert(Coin50 === Coin50)
    assert(Coin100 === Coin100)
    assert(Coin500 === Coin500)
    assert(Bill1000 === Bill1000)
  }

  test ("Moneyから金額値を取得できる") {
    assert((Coin10: Money).value === 10)
    assert((Coin50: Money).value === 50)
    assert((Coin100: Money).value === 100)
    assert((Coin500: Money).value === 500)
    assert((Bill1000: Money).value === 1000)
  }
}
