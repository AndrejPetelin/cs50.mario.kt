/**
 * Created by Andrej on 7.6.2017.
 */

import java.lang.NumberFormatException

tailrec fun strGen(ch: Char, accum: String, n: Int): String {
    if (n == 0) return accum
    else return strGen(ch, accum + ch, n - 1)
}

tailrec fun getInt(): Int {
    var ret : Int? = null
    try {
        ret = readLine()?.toInt()
    }
    catch (e: NumberFormatException) {
        print("Retry: ")
    }
    return ret ?: getInt()
}

tailrec fun getValidInput(): Int {
    print("Height: ")
    val input = getInt()
    when (input) {
        in 0..23 -> return input
        else -> return getValidInput()
    }
}

fun main(argv: Array<String>) {
    val height = getValidInput()
    for (i in 1..height) {
        println(strGen(' ', "", height - i) + strGen('#', "", i + 1))
    }
}
