case class VendingMachine(total: Int, stock: Map[Drink, Int])

object VendingMachine {
  val init: VendingMachine = VendingMachine(0, Map(Drink.coke -> 5))
  def insert(money: UsableMoney)(vm: VendingMachine): VendingMachine =
    vm.copy(total = vm.total + money.value)
  def payback(vm: VendingMachine): (VendingMachine, Int) = (vm.copy(total = 0), vm.total)
  def afford(total: Int)(drink: Drink): Boolean = total >= drink.price

  // TODO: ScalazとScalaTestの===がバッティングしたので仕方なくゴリッと書いた。気が向いたら直したい。
  implicit class RichVendingMachine(val vm: VendingMachine) extends AnyVal {
    def |>[T] (f: VendingMachine => T): T = f(vm)
  }
}