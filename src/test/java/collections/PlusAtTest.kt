package collections

import org.junit.Test
import kotlin.test.assertEquals

@Suppress("FunctionName")
class PlusAtTest {

    @Test
    fun `Simple plusAt tests`() {
        val list = listOf(1,2,3)
        assertIsThrowingError { list.plusAt(-1, 100) }
        assertIsThrowingError { list.plusAt(-100, 100) }
        assertIsThrowingError { list.plusAt(1000, 100) }
        assertEquals(listOf(100, 1, 2, 3), list.plusAt(0, 100))
        assertEquals(listOf(1, 100, 2, 3), list.plusAt(1, 100))
        assertEquals(listOf(1, 2, 3, 100), list.plusAt(3, 100))
    }

    private fun <T> assertIsThrowingError(f: () -> T) {
        try {
            f()
        } catch (r: Throwable) {
            return
        }
        assert(false)
    }
}