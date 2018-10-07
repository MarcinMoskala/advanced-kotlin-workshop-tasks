@file:Suppress("RedundantSuspendModifier", "unused", "DEPRECATION", "UNUSED_PARAMETER")

package coroutines.examples

import kotlinx.coroutines.experimental.*
import java.util.concurrent.atomic.AtomicInteger
import kotlin.system.measureTimeMillis

private var counter = 0

fun main(args: Array<String>) = runBlocking {
    GlobalScope.massiveRun {
        counter++
    }
    println("Counter = ${counter}")
}

suspend fun CoroutineScope.massiveRun(action: suspend () -> Unit) {
    val jobs = List(1000) {
        launch {
            repeat(1000) { action() }
        }
    }
    jobs.forEach { it.join() }
}