@file:Suppress("RedundantSuspendModifier", "unused", "DEPRECATION", "UNUSED_PARAMETER")

package coroutines.examples

import kotlinx.coroutines.experimental.*
import kotlinx.coroutines.experimental.sync.Mutex
import kotlinx.coroutines.experimental.sync.withLock
import java.util.concurrent.atomic.AtomicInteger
import kotlin.system.measureTimeMillis

private val mutex = Mutex()
private var counter = 0

fun main(args: Array<String>) = runBlocking<Unit> {
    GlobalScope.massiveRun {
        mutex.withLock {
            counter++
        }
    }
    println("Counter = $counter")
}