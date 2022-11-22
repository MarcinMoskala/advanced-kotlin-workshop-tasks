package functional

fun zeroComplex(): Complex = Complex(0.0, 0.0)
fun makeComplex(real: Double = 0.0, imaginary: Double = 0.0): Complex = Complex(real, imaginary)

data class Complex(var real: Double, val imaginary: Double) {
    fun doubled(): Complex = Complex(this.real * 2, this.imaginary * 2)
    fun times(num: Int) = Complex(real * num, imaginary * num)
}

fun Complex.plus(other: Complex): Complex = Complex(real + other.real, imaginary + other.imaginary)
fun Int.toComplex(): Complex = Complex(this.toDouble(), 0.0)

fun produceAndPrint(producer: () -> Complex) {
    println(producer())
}

fun main() {
    val c0: Complex = zeroComplex()
    val c1: Complex = makeComplex(1.0, 2.0)
}
