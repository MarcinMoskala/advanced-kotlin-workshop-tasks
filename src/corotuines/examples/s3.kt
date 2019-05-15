package coroutines.examples.n2

import coroutines.examples.massiveRun
import kotlinx.coroutines.*

private var counter = 0

fun main() = runBlocking {
    val counterContext = newSingleThreadContext("CounterContext")

    GlobalScope.massiveRun {
        withContext(counterContext) {
            counter++
        }
    }
    println("Counter = $counter")
}