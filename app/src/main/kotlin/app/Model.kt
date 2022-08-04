package app

import com.google.gson.Gson
import java.io.File
import java.io.Serializable
import java.time.LocalDateTime

//Using Singleton pattern to prevent data corruption
class Model private constructor() {

    private val REPO_FILENAME = "gamerepository.json"
    private lateinit var m_repo: GameRepository

    companion object {
        private var m_instance : Model? = null

        fun instance() : Model {
            if (m_instance == null) {
                val model = Model()
                model.init()
                m_instance = model
            }
            return m_instance as Model
        }
    }

    private fun init() {
        val repoFile = File(REPO_FILENAME)
        if (repoFile.exists()) {
            val repoContent = File(REPO_FILENAME).readText(Charsets.UTF_8)
            m_repo = Gson().fromJson(repoContent, GameRepository::class.java)
        } else {
            m_repo = GameRepository(arrayListOf())
        }
    }

    fun listStoredGames() : List<String> {
        return m_repo.games.map { game -> game.name }
    }

    fun newGame(name: String) {
        val newGame = GameData(
                name,
                initDecks(),
                hashMapOf(),
                arrayListOf()
        )
        m_repo.games.add(newGame)
        writeToDisk(m_repo)
    }

    private fun initDecks() : HashMap<Int, ArrayList<Card>> {
        return hashMapOf()
    }

    private fun writeToDisk(repo: GameRepository) {
        val jsonString = Gson().toJson(repo)
        println(jsonString.toString())
        File(REPO_FILENAME).writeText(jsonString.toString())
    }
}