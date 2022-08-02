package app

import java.lang.Exception

enum class Result {
    New,
    Continue,
    Quit,
    Error
}

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

data class Option (val option: Int, val text: String)

fun ask(question:String, options: ArrayList<Option>) : Option {
    while (true) {
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
            println("Input error, please try again")

            //println(e)
        }
    }
}