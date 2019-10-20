package functional

data class Rational(val numerator: Int, val denominator: Int)

fun Int.r(): Rational = TODO()
fun Pair<Int, Int>.r(): Rational = TODO()

fun main(args: Array<String>) {
    print(1.r())
    print((1 to 2).r())
}