package functional

import org.junit.Test
import kotlin.test.assertEquals

class RationalTest {
    @Test
    fun testIntExtension() {
        assertEquals(Rational(4, 1), 4.r())
    }

    @Test fun testPairExtension() {
        assertEquals(Rational(2, 3), Pair(2, 3).r())
    }
}