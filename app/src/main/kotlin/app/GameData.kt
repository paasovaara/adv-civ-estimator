package app

import kotlinx.serialization.Serializable

@Serializable
abstract class Card(
        open val type: String,
        open val deck: Int,
        open val name: String,
        val isCalamity: Boolean
) /*{
    abstract val isCalamity: Boolean
}*/

@Serializable
class CommodityCard(
        type: String,
        deck: Int,
        name: String
) : Card(
    type, deck, name, false
)

data class GameData(
    val name: String
)
