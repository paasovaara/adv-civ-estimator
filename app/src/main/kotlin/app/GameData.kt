package app

import com.google.gson.Gson
import java.io.Serializable

enum class CardType {
    Bone, Clay, Hides,
    Iron, Stone, Wax,
    Ceramics, Fish, Salt,
    Cotton, Grain, Oil,
    Glass, Livestock, Wine,
    Copper, Lead, Silver,
    Herbs, Resin, Spice,
    Dye, Gemstones, Obsidian,
    Amber, Gold, Silk,
    SquanderedWealth, Treachery, Volcano,
    Tempest, Superstition, Famine,
    CityInFlames, SlaveRevolt, CivilWar,
    CityRiots, Barbarians, Flood,
    CoastalMigration, Epidemic, Cyclone,
    TribalConflict, CivilDisorder, Corruption,
    MinorUprising, IconoclasmAndHeresy, Tyranny,
    Banditry, Piracy, Regression;

    fun deck(): Int {
        return when(this) {
            Bone, Clay, Hides -> 1
            else -> 2 //TODO()
        }
    }

    fun isCalamity(): Boolean {
        return when(this) {
            SquanderedWealth, Treachery, Volcano,
            Tempest, Superstition, Famine,
            CityInFlames, SlaveRevolt, CivilWar,
            CityRiots, Barbarians, Flood,
            CoastalMigration, Epidemic, Cyclone,
            TribalConflict, CivilDisorder, Corruption,
            MinorUprising, IconoclasmAndHeresy, Tyranny,
            Banditry, Piracy, Regression -> true
            else -> false
        }
    }

    fun isNonTradeableCalamity(): Boolean {
        return when(this) {
            Volcano,
            Famine,
            CivilWar,
            Flood,
            Cyclone,
            Corruption,
            Tyranny,
            Regression -> true
            else -> false
        }
    }
}

data class Card(val type: CardType) {


    fun deck(): Int {
        return when(type) {
            CardType.Bone, CardType.Clay, CardType.Hides -> 1
            CardType.Iron, CardType.Stone, CardType.Wax,
            CardType.SquanderedWealth, CardType.Treachery, CardType.Volcano -> 2
            CardType.Ceramics -> TODO()
            CardType.Fish -> TODO()
            CardType.Salt -> TODO()
            CardType.Cotton -> TODO()
            CardType.Grain -> TODO()
            CardType.Oil -> TODO()
            CardType.Glass -> TODO()
            CardType.Livestock -> TODO()
            CardType.Wine -> TODO()
            CardType.Copper -> TODO()
            CardType.Lead -> TODO()
            CardType.Silver -> TODO()
            CardType.Herbs -> TODO()
            CardType.Resin -> TODO()
            CardType.Spice -> TODO()
            CardType.Dye -> TODO()
            CardType.Gemstones -> TODO()
            CardType.Obsidian -> TODO()
            CardType.Amber -> TODO()
            CardType.Gold -> TODO()
            CardType.Silk -> TODO()
            CardType.Tempest -> TODO()
            CardType.Superstition -> TODO()
            CardType.Famine -> TODO()
            CardType.CityInFlames -> TODO()
            CardType.SlaveRevolt -> TODO()
            CardType.CivilWar -> TODO()
            CardType.CityRiots -> TODO()
            CardType.Barbarians -> TODO()
            CardType.Flood -> TODO()
            CardType.CoastalMigration -> TODO()
            CardType.Epidemic -> TODO()
            CardType.Cyclone -> TODO()
            CardType.TribalConflict -> TODO()
            CardType.CivilDisorder -> TODO()
            CardType.Corruption -> TODO()
            CardType.MinorUprising -> TODO()
            CardType.IconoclasmAndHeresy -> TODO()
            CardType.Tyranny -> TODO()
            CardType.Banditry -> TODO()
            CardType.Piracy -> TODO()
            CardType.Regression -> TODO()
        }
    }

}

/*abstract class Card(
        open val type: CardType,
        open val deck: Int,
        open val name: String,
) {
    abstract val isCalamity: Boolean
}

class CommodityCard(
        type: String,
        deck: Int,
        name: String
) : Card(
    type, deck, name
) {
    override val isCalamity: Boolean
        get() = false
}*/

data class GameData(
    val name: String,
    val cardDecks: HashMap<Int, ArrayList<Card>>,
    val dealtCards: HashMap<Int, ArrayList<Card>>,
    val roundIndexes: ArrayList<Int>
)
