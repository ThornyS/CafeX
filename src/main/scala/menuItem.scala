/**
  * Set food types for differing service charges.
*/
sealed trait ItemType
object HotFood extends ItemType
object Drink extends ItemType
object Food extends ItemType

case class menuItem (name: String, itemType: ItemType, price: BigDecimal)
