package collections

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

fun <T> List<T>.plusAt(index: Int, element: T): List<T> = TODO()

@Suppress("FunctionName")
class PlusAtTests {

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
        } catch (r: Error) {
            return
        }
        assert(false)
    }
}