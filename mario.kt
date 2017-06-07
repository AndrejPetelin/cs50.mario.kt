/**
 * Created by Andrej on 7.6.2017.
 */

import java.lang.NumberFormatException

/*
 * tail-recursive function that generates a string of identical characters
 */
tailrec fun strGen(ch: Char, accum: String, n: Int): String {
    if (n == 0) return accum
    else return strGen(ch, accum + ch, n - 1)
}

/*
 * tail-recursive Kotlin version of CS50's getInt() function
 */
tailrec fun getInt(): Int {
    var ret : Int? = null

    // attempt to retrieve an int from input. toInt() throws a NumberFormatException if input can't be
    // converted to an Int so we catch and prompt for retry. ret will remain null if input is not valid.
    try {
        ret = readLine()?.toInt()
    }
    catch (e: NumberFormatException) {
        print("Retry: ")
    }

    // return an Int or recurse until ret not null
    return ret ?: getInt()
}

/*
 * tail-recursive function for geting an integer input in the range 0 to 23 inclusive.
 */
tailrec fun getValidInput(): Int {
    // prompt and read input via getInt()
    print("Height: ")
    val input = getInt()

    // return if value is correct or recursively try again
    // note that if is an expression in Kotlin :)
    return if (input in 0..23) input else getValidInput()
}

fun main(argv: Array<String>) {
    // take input, getValidInput() makes sure input is an integer in the correct range
    val height = getValidInput()

    // generate height lines of spaces and hashes
    for (i in 1..height) {
        println(strGen(' ', "", height - i) + strGen('#', "", i + 1))
    }
}
