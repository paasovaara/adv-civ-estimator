package app

//Using Singleton pattern to prevent data corruption
class Model private constructor() {
    companion object {
        private var m_instance : Model? = null

        fun instance() : Model {
            if (m_instance == null) {
                m_instance = Model()
            }
            return m_instance as Model
        }
    }

    fun listStoredGames() : ArrayList<String> {
        //TODO
        return arrayListOf()
    }

    fun newGame(name: String) {

    }
}