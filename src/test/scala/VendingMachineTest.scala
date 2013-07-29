import org.scalatest.FunSuite
import VendingMachine._

class VendingMachineTest extends FunSuite {

  test ("投入金額の総計を取得すると、0が返ってくる") {
    val total: Int = init.total
    assert(total === 0)
  }

  test ("10円を投入して投入金額の総計を取得すると、10が返ってくる") {
    assert((init |> insert(Coin10)).total === 10)
  }

  test ("100円を投入して投入金額の総計を取得すると、100が返ってくる") {
    assert((init |> insert(Coin100)).total === 100)
  }

  test ("10円→100円の順に投入して投入金額の総計を取得すると、110が返ってくる") {
    assert((init |> insert(Coin10) |> insert(Coin100)).total === 110)
  }

  test ("10円を投入して払い戻し操作を行うと、10が返り、投入金額が0に戻る") {
    val (vm, pb) = init |> insert(Coin10) |> payback
    assert(vm.total === 0)
    assert(pb === 10)
  }

// そもそもコンパイルエラーになるのでコメントアウツ
//  test ("1円を投入することはできない") {
//    init |> insert(Coin1)
//  }

  test ("格納されているジュースを取得すると、120円のコーラが5本取得できる") {
    assert(init.stock === Map(Drink.coke -> 5))
  }

  test ("投入金額が120円の場合に、金額面でコーラを買える") {
    assert(afford(120)(Drink.coke) === true)
  }

  test ("投入金額が100円の場合に、金額面でコーラを買えない") {
    assert(afford(100)(Drink.coke) === false)
  }

}
