package extra

import functional.factorial
import functional.product
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

/**
 *  Permutations are all different ways to arrange elements from some collection (https://en.wikipedia.org/wiki/Permutation).
 *  For sets it's number is n!, for lists it is n! / (n1! * n2! * ...) where n1, n2... are numbers elements that are the same.
 */

/* This function returns number of all permutations of elements from set. It is equal to n! where n is size of set. */
fun <T> Set<T>.permutationsNumber(): Long = factorial(size)

/* This function returns number of all permutations of elements from list. It is equal to n! / (n1! * n2! * ...) where n1, n2... are numbers elements that are the same. */
fun <T> List<T>.permutationsNumber(): Long = if (size < 1) 1L else factorial(size) / groupBy { it }.map { factorial(it.value.size) }.product()

/* This function returns all permutations of elements from set. These are different ways to arrange elements from this list.  */
fun <T> Set<T>.permutations(): Set<List<T>> = TODO()

/* This function returns all permutations of elements from list. These are different ways to arrange elements from this list.  */
fun <T> List<T>.permutations(): Set<List<T>> = TODO()

@Suppress("FunctionName")
internal class PermutationTests {

    @Test
    fun `Test permutation numbers for Sets with different sizes`() {
        val setSizeToPermutations = mapOf(
                0 to 1L,
                1 to 1L,
                2 to 2L,
                3 to 6L,
                4 to 24L
        )
        for ((setSize, expectedNumber) in setSizeToPermutations) {
            val set = (1..setSize).toSet()
            assertEquals(expectedNumber, set.permutationsNumber())
        }
    }

    @Test
    fun `Test permutation numbers for Lists with different sizes and different elements`() {
        val listSizeToPermutations = mapOf(
                0 to 1L,
                1 to 1L,
                2 to 2L,
                3 to 6L,
                4 to 24L
        )
        for ((listSize, expectedNumber) in listSizeToPermutations) {
            val set = (1..listSize).toList()
            assertEquals(expectedNumber, set.permutationsNumber())
        }
    }

    @Test
    fun `Test permutation numbers for Lists with different sizes and same elements`() {
        val listToPermutations = mapOf(
                listOf(1, 1, 1, 1) to 1L,
                listOf(1, 1, 2, 2) to 6L,
                listOf(1, 1, 1, 2) to 4L
        )
        for ((list, expectedNumber) in listToPermutations) {
            assertEquals(expectedNumber, list.permutationsNumber())
        }
    }

    @Test
    fun `Get all permutations for different elements`() {
        val setToPermutations = mapOf(
                setOf<Int>() to setOf<List<Int>>(),
                setOf(1, 2) to setOf(listOf(1, 2), listOf(2, 1)),
                setOf(1, 2, 3) to setOf(listOf(1, 2, 3), listOf(2, 1, 3), listOf(1, 3, 2), listOf(2, 3, 1), listOf(3, 1, 2), listOf(3, 2, 1))
        )
        for ((set, allExpectedPermutations) in setToPermutations) {
            assertEquals(allExpectedPermutations, set.permutations())
        }
    }

    @Test
    fun `Check permutations number in allPermutations for bigger numbers`() {
        val set = (1..5).toSet()
        assertEquals(set.permutationsNumber(), set.permutations().size.toLong())
    }
}