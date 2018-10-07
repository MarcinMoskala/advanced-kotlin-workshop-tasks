@file:Suppress("RedundantSuspendModifier", "unused", "DEPRECATION", "UNUSED_PARAMETER")

package coroutines.examples

import kotlinx.coroutines.experimental.*
import java.util.concurrent.atomic.AtomicInteger
import kotlin.system.measureTimeMillis

private var counter = 0

fun main(args: Array<String>) = runBlocking {
    val counterContext = newSingleThreadContext("CounterContext")
    GlobalScope.massiveRun {
        withContext(counterContext) {
            counter++
        }
    }
    println("Counter = $counter")
}