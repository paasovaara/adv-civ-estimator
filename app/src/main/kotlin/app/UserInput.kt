package app

import java.lang.Exception

object UserInput {
    enum class Result {
        New,
        Continue,
        Quit,
        Error,
        AddData,
        Simulate
    }

    private data class Option (val option: Int, val text: String)

    fun askNewOrContinue() : Result {
        val options: ArrayList<Option> = arrayListOf(
                Option(1, "Start a new game"),
                Option(2, "Continue existing game"),
                Option(3, "Quit"),
        )
        val selection = ask("Welcome! What do you want to do?", options)
        when (selection.option) {
            1 -> return Result.New
            2 -> return Result.Continue
            3 -> return Result.Quit
        }
        return Result.Error
    }

    fun askMoreDataOrSimulation() : Result {
        val options: ArrayList<Option> = arrayListOf(
                Option(1, "Add spent cards"),
                Option(2, "Simulate the next hand"),
                Option(3, "Quit"),
        )
        val selection = ask("Add data or estimate the next hand?", options)
        when (selection.option) {
            1 -> return Result.AddData
            2 -> return Result.Simulate
            3 -> return Result.Quit
        }
        return Result.Error
    }

    fun askNewGame() : String {
        return ask("Please enter the name for this new game")
    }
    private fun ask(question: String) : String {
        println(question)
        //TODO improve error handling to be more consistent, now this throws instead of returns an error
        return readln().trim()
    }

    private fun ask(question:String, options: ArrayList<Option>) : Option {
        while (true) {
            println("===================================")
            println(question)
            for (option in options) {
                println("${option.option}) ${option.text}")
            }
            try {
                val input = readln().trim()
                val selection = input.toInt()
                val match = options.filter { o -> o.option == selection }
                if (match.size == 1)
                    return match[0]
                else
                    println("Not a valid option, please try again")
            } catch (e: Exception) {
                println("Input error, please try again. Error: ${e.message}")
            }
        }
    }
}
