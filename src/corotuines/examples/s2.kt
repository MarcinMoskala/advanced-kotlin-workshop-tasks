package coroutines.examples.n1

import coroutines.examples.massiveRun
import kotlinx.coroutines.*
import java.util.concurrent.atomic.AtomicInteger

private var counter = AtomicInteger()

fun main() = runBlocking {
    GlobalScope.massiveRun {
        counter.incrementAndGet()
    }
    println("Counter = ${counter.get()}")
}
