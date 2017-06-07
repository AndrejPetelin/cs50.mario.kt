/**
 * Created by andrej on 7.6.2017.
 * CS50 problem set 1 - greedy.c in Kotlin
 * This is just to get a taste of Kotlin
 */

package greedy

/**
 * tail-recursive Kotlin version of CS50's getFloat() function
 */
tailrec fun getFloat(): Float {
    var ret : Float? = null

    // attempt to retrieve an int from input. toFloat() throws a NumberFormatException if input can't be
    // converted to a Float so we catch and prompt for retry. ret will remain null if input is not valid.
    try {
        ret = readLine()?.toFloat()
    }
    catch (e: NumberFormatException) {
        print("Retry: ")
    }

    // return an Int or recurse until ret not null
    return ret ?: getFloat()
}

tailrec fun getValidInput(): Float {
    // prompt and read input via getFloat()
    println("How much change is owed?")
    val input = getFloat()

    if (input < 0.0) return getValidInput()
    else return input
}

/*
 * The greedy function. Takes input function and a descending array of denominations
 * as argument, converts return to cents, calculates and returns  minimal number of
 * coins given the denomination array. Note array has to be descending and that the
 * something like [25, 20, 1] is not going to give the correct minimal result
 *  since 40 should give 2, but this algorithm would give 16
 */
fun greedy(getChange: () -> Float, denom: Array<Int>): Int {
    var change = Math.round(getChange() * 100)
    var coins = 0

    for (d in denom) {
        coins += change / d
        change %= d
    }

    return coins
}

fun main(argv: Array<String>) {
    print("O hai! ")

    // pass input function by reference, denomination array to greedy and store result
    val result = greedy(::getValidInput, arrayOf(25, 10, 5, 1))

    println(result)
}


