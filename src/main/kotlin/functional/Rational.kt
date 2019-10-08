package functional

data class RationalNumber(val numerator: Int, val denominator: Int)

fun Int.r(): RationalNumber = TODO()
fun Pair<Int, Int>.r(): RationalNumber = TODO()

fun main(args: Array<String>) {
    print(1.r())
    print((1 to 2).r())
}