package collections

// To prevent unintentional stdlib functions usage
import kotlin.collections.flatMap as stdlibFlatMap
import kotlin.collections.forEach as stdlibForEach
import kotlin.collections.map as stdlibMap
import kotlin.collections.filter as stdlibFilter

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