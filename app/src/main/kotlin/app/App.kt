package app

import kotlinx.cli.*
import app.UserInput

class App {
    companion object {
        const val appName = "Advanced Civ Estimator"
        const val version = "0.0.1"
        val greeting: String
            get() {
                return  "     _       _                               _    ____ _        \n" +
                        "    / \\   __| |_   ____ _ _ __   ___ ___  __| |  / ___(_)_   __ \n" +
                        "   / _ \\ / _` \\ \\ / / _` | '_ \\ / __/ _ \\/ _` | | |   | \\ \\ / / \n" +
                        "  / ___ \\ (_| |\\ V / (_| | | | | (_|  __/ (_| | | |___| |\\ V /  \n" +
                        " /_/   \\_\\__,_| \\_/ \\__,_|_| |_|\\___\\___|\\__,_|  \\____|_| \\_/   \n" +
                        "                                                                "
            }
    }

    fun launch() {
        var result = UserInput.askNewOrContinue()
        while (result != UserInput.Result.Quit && result != UserInput.Result.Error) {
            when (result) {
                UserInput.Result.New -> initNewGame()
                UserInput.Result.Continue -> println("continue")
                UserInput.Result.AddData -> println("add data")
                UserInput.Result.Simulate -> println("simulate")
                else -> println("Unexpected error!!")
            }

            result = UserInput.askMoreDataOrSimulation()
        }
        println("Bye bye")
    }

    private fun initNewGame() {
        val gameName = UserInput.askNewGame()

    }
}

fun main(args: Array<String>) {
    println(App.greeting)

    val parser = ArgParser("${App.appName}:: ${App.version}")
    val version by parser.option(ArgType.Boolean, shortName = "v", description = "Version").default(false)

    parser.parse(args)
    if (version) {
        println(App.version)
    } else {
        val app = App()
        app.launch()
    }
}
