package app

import kotlinx.cli.*

class App {
    companion object {
        val appName = "Advanced Civ Estimator"
        val version = "0.0.1"
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
        askNewOrContinue()
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
