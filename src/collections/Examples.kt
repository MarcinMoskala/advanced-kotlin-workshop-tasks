package collections

// To prevent unintentional stdlib functions usage
import junit.framework.Assert.assertEquals
import org.junit.Assert
import org.junit.Assert.assertEquals
import org.junit.Test
import kotlin.collections.flatMap as `Implement it yourself and do not delete this line!`
import kotlin.collections.forEach as `Implement it yourself and do not delete this line!!`
import kotlin.collections.map as `Implement it yourself and do not delete this line!!!`
import kotlin.collections.filter as `Implement it yourself and do not delete this line!!!!`

inline fun <T> Iterable<T>.forEach(operation: (T) -> Unit) {
    for (elem in this) {
        operation(elem)
    }
}

inline fun <T, R> Iterable<T>.map(transformation: (T) -> R): List<R> {
    val list = arrayListOf<R>()
    for (elem in this) {
        list.add(transformation(elem))
    }
    return list
}

inline fun <T> Iterable<T>.filter(predicate: (T) -> Boolean): List<T> {
    val list = arrayListOf<T>()
    for (elem in this) {
        if (predicate(elem)) {
            list.add(elem)
        }
    }
    return list
}

fun main(args: Array<String>) {
    (1..1000).filter { it % 7 == 0 }
            .map { "$it" }
            .filter { it.first() == '9' }
            .forEach { println(it) }

    (1..100).filter { it % 7 == 0 }
//            .flatMap { num -> (1..5).map { num + 10 * it } }
            .forEach { println(it) }
}

class FlatMapTest {

    @Test
    fun `When empty collections are produced, flatMap returns an empty collection as well`() {
//        assertEquals(emptyList<Int>(), (1..100).flatMap { emptyList<Int>() })
//        assertEquals(emptyList<String>(), (1..100).flatMap { emptyList<String>() })
    }

    @Test
    fun `When a collection with a single element produced, flatMap returns a list with this elements`() {
        val list = List(1000) { it }
//        assertEquals(list, list.flatMap { listOf(it) })
//        assertEquals(list, list.flatMap { setOf(it) })
    }

    @Test
    fun `When a few elements are produced, they are accumulated`() {
        val elems = 1..5
//        assertEquals(listOf(1, 101, 2, 102, 3, 103, 4, 104, 5, 105), elems.flatMap { listOf(it, it + 100) })
    }
}