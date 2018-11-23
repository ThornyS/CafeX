/**
  * Use 'org.specs2' to run 'should' expect tests
  * Step 1: pass in list of purchased items that produces a total bill.
  * Step 2: Add service charge when;
  *   - all items are drinks - No charge
  *   - any items is of type food add 10% charge
  *   - any HotFood items add 20% to a max of 20GBP
  *
  * Menu:
  * "Cola" -> 0.50,
  * "Coffee" -> 1.00,
  * "Cheese Sandwich" -> 2.00,
  * "Steak Sandwich" -> 4.50 # HotFood
  */

import org.specs2.mutable.Specification

class CafeXSpec extends Specification {

  "CafeX" should {

    "Step 1: Produce a total bill with list of purchased items" in {
      val purchasedItems = List("Cola", "Coffee")
      CafeX.bill(purchasedItems) shouldEqual BigDecimal("1.50")
    }

    "Step 2: No service charge when all drinks bought" in {
      val purchasedItems = List("Cola", "Cola", "Coffee", "Coffee")
      CafeX.bill(purchasedItems) shouldEqual BigDecimal("3.00")
    }

    "Step 2: 10% service charge with food (No HotFood)" in {
      val purchasedItems = List("Coffee", "Cheese Sandwich")
      CafeX.bill(purchasedItems) shouldEqual BigDecimal("3.30")
    }

    "Step 2: 20% service charge with HotFood up to max of 20 GBP" in {
      val purchasedItems = List("Cola", "Cheese Sandwich") ::: List.fill(22)("Steak Sandwich")
      CafeX.bill(purchasedItems) shouldEqual BigDecimal("57.0")
    }

   }
}
