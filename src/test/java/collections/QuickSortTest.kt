package collections

import org.junit.jupiter.api.Test
import java.util.*
import kotlin.test.assertEquals

@Suppress("FunctionName")
class QuickSortTest {

    @Test
    fun `Empty list is sorted`() {
        assertEquals(emptyList(), emptyList<Int>().quickSort())
    }

    @Test
    fun `Single element is sorted`() {
        assertEquals(listOf(1), listOf(1).quickSort())
    }

    @Test
    fun `Simple numbers sorting`() {
        assertEquals(listOf(1, 2, 3, 5, 6), listOf(3, 2, 5, 1, 6).quickSort())
    }

    @Test
    fun `Simple String sorting`() {
        assertEquals(listOf("A", "B", "C", "D"), listOf("C", "D", "A", "B").quickSort())
    }

    @Test
    fun `Random list sorting should give the same result as when we use stdlib sorted function`() {
        val rand = Random(244252)
        val listOfRandomLists = (1..100).map { _ -> (1..100).map { rand.nextInt() } }
        for (list: List<Int> in listOfRandomLists) {
            assertEquals(list.sorted(), list.quickSort())
        }
    }
}