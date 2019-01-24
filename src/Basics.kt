import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

// https://en.wikipedia.org/wiki/Greatest_common_divisor
fun gcd(a: Int, b: Int): Int = TODO()

// Fibonacci number that starts from 1 and 1 (fib(0) == 1, fib(1) == 1, fib(2) == 2, fib(3) == 3, fib(4) == 5, fib(5) == 8)
// https://en.wikipedia.org/wiki/Fibonacci_number
fun fib(n: Int): Int = TODO()

@Suppress("FunctionName")
internal class BasicsTests {

    @Test
    fun `gcd returnes x for x and x`() {
        assertEquals(5, gcd(5, 5))
        assertEquals(7, gcd(7, 7))
        for (x in 1..100) {
            assertEquals(x, gcd(x, x))
        }
    }

    @Test
    fun `gcd returnes 1 when x and y are primes`() {
        assertEquals(1, gcd(3, 7))
        assertEquals(1, gcd(5, 7))

        for ((x, y) in twoDifferentPrimesPermutations) {
            assertEquals(1, gcd(x, y), "Should be 1 for $x and $y, but is ${gcd(x, y)}")
        }
    }

    @Test
    fun `gcd for simple examples`() {
        assertEquals(4, gcd(12, 8))
        assertEquals(3, gcd(12, 6))
        assertEquals(14, gcd(42, 56))
        assertEquals(18, gcd(461952, 116298))
        assertEquals(32, gcd(7966496, 314080416))
        assertEquals(526, gcd(24826148, 45296490))
    }

    @Test
    fun `gcd x and 0 gives x`() {
        assertEquals(12, gcd(12, 0))
        assertEquals(0, gcd(0, 0))
        assertEquals(9, gcd(0, 9))
    }

    @Test
    fun `fib first numbers`() {
        assertEquals(1, fib(0))
        assertEquals(1, fib(1))
        assertEquals(2, fib(2))
        assertEquals(3, fib(3))
        assertEquals(5, fib(4))
        assertEquals(8, fib(5))
        assertEquals(13, fib(6))
        assertEquals(21, fib(7))
        assertEquals(34, fib(8))
        assertEquals(55, fib(9))
        assertEquals(89, fib(10))
    }

    companion object {
        private val somePrimes = listOf(2, 3, 5, 7, 11, 13, 17, 19)

        private val twoDifferentPrimesPermutations = somePrimes
                .flatMap { p1 -> somePrimes.map { p2 -> p1 to p2 } }
                .filter { (p1, p2) -> p1 != p2 }
    }
}