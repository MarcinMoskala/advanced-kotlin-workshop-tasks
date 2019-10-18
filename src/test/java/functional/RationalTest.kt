package functional

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class RationalTest {
    @Test
    fun testIntExtension() {
        assertEquals(RationalNumber(4, 1), 4.r())
    }

    @Test fun testPairExtension() {
        assertEquals(RationalNumber(2, 3), Pair(2, 3).r())
    }
}