/**
  * CafeX
  * Has Menu of 'menuItems', a bill and service charges.
  */
object CafeX {

  private val menuItems: Map[String, menuItem] = Map(
    "Cola" -> menuItem("Cola", Drink, BigDecimal("0.50")),
    "Coffee" -> menuItem("Coffee", Drink, BigDecimal("1.00")),
    "Cheese Sandwich" -> menuItem("Cheese Sandwich", Food, BigDecimal("2.00")),
    "Steak Sandwich" -> menuItem("Steak Sandwich", HotFood, BigDecimal("4.50"))
  )

  def bill(purchasedItems: List[String]): BigDecimal = {
    var currentTotal = purchasedItems.foldLeft(BigDecimal("0.00"))(_ + menuItems(_).price)

    /**
      * Calc service charge percentage based on items found in purchasedItems
      */
    if (purchasedItems.exists(menuItems(_).itemType == HotFood)) {
      println("currentotal = " + currentTotal + "\nservice total = " + (currentTotal * BigDecimal("0.2")).min(20))
      currentTotal = currentTotal + (currentTotal * BigDecimal("0.2")).min(20)
    } else if (purchasedItems.exists(menuItems(_).itemType == Food)) {
      currentTotal = (currentTotal * BigDecimal("1.1"))
    } else {
      currentTotal = currentTotal
    }

    return currentTotal
  }

}
