import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

@Suppress("FunctionName")
internal class BasicsTest {

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
        assertEquals(6, gcd(12, 6))
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
    fun `FizzBuzz prints 100 elements`() {
        val list = fuzzBuzzPrinted()
        assertEquals(100, list.size)
    }

    @Test
    fun `FizzBuzz starts from 1 and 2`() {
        val (first, second) = fuzzBuzzPrinted()
        assertEquals("1", first)
        assertEquals("2", second)
    }

    @Test
    fun `Third FizzBuzz element is Fizz`() {
        val (_, _, third) = fuzzBuzzPrinted()
        assertEquals("Fizz", third)
    }

    @Test
    fun `Fifth FizzBuzz element is Buzz`() {
        val (_, _, _, _, fifth) = fuzzBuzzPrinted()
        assertEquals("Buzz", fifth)
    }

    @Test
    fun `Fifteenth FizzBuzz element is FizzBuzz`() {
        val text = fuzzBuzzPrinted()
        assertEquals("FizzBuzz", text[14])
    }

    @Test
    fun `Every third element returns Fizz`() {
        val text = fuzzBuzzPrinted()
        for (position in positionsForNumbersDividableBy(3)) {
            assertTrue("Fizz" in text[position])
        }
    }

    @Test
    fun `Every fifth element returns Fizz`() {
        val text = fuzzBuzzPrinted()
        for (position in positionsForNumbersDividableBy(5)) {
            assertTrue("Buzz" in text[position])
        }
    }

    @Test
    fun `Every fifteenth element returns FizzBuzz`() {
        val text = fuzzBuzzPrinted()
        for (position in positionsForNumbersDividableBy(15)) {
            assertEquals("FizzBuzz", text[position])
        }
    }

    private fun positionsForNumbersDividableBy(num: Int) =
        (1..100).filter { it % num == 0 }.map { it - 1 }

    @Test
    fun fizzBuzzTest() {
        val text = fuzzBuzzPrinted()
        val solution =
            "1\n2\nFizz\n4\nBuzz\nFizz\n7\n8\nFizz\nBuzz\n11\nFizz\n13\n14\nFizzBuzz\n16\n17\nFizz\n19\nBuzz\nFizz\n22\n23\nFizz\nBuzz\n26\nFizz\n28\n29\nFizzBuzz\n31\n32\nFizz\n34\nBuzz\nFizz\n37\n38\nFizz\nBuzz\n41\nFizz\n43\n44\nFizzBuzz\n46\n47\nFizz\n49\nBuzz\nFizz\n52\n53\nFizz\nBuzz\n56\nFizz\n58\n59\nFizzBuzz\n61\n62\nFizz\n64\nBuzz\nFizz\n67\n68\nFizz\nBuzz\n71\nFizz\n73\n74\nFizzBuzz\n76\n77\nFizz\n79\nBuzz\nFizz\n82\n83\nFizz\nBuzz\n86\nFizz\n88\n89\nFizzBuzz\n91\n92\nFizz\n94\nBuzz\nFizz\n97\n98\nFizz\nBuzz"
        assertEquals(solution, text.joinToString(separator = "\n") { it.trim() })
    }

    private fun fuzzBuzzPrinted(): List<String> {
        val printedLines = mutableListOf<String>()
        val printer = object : Console {
            override fun println(text: String) {
                printedLines += text
            }
        }
        fizzBuzz(printer)
        return printedLines
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