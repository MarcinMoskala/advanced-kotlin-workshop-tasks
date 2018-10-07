@file:Suppress("RedundantSuspendModifier", "unused", "DEPRECATION", "UNUSED_PARAMETER")

package coroutines.examples

import kotlinx.coroutines.experimental.*

val threadLocal = ThreadLocal<String?>()

fun main(args: Array<String>) = runBlocking {
    fun threadName() = Thread.currentThread().name

    threadLocal.set("main")
    println("Pre-main, current thread: ${threadName()}, thread local value: '${threadLocal.get()}'")
    val job = launch(Dispatchers.Default + threadLocal.asContextElement(value = "launch")) {
        println("Launch, thread: ${threadName()}, value: '${threadLocal.get()}'")
        yield()
        println("Yielded, thread: ${threadName()}, value: '${threadLocal.get()}'")
    }
    job.join()
    println("Post-main, thread: ${threadName()}, value: '${threadLocal.get()}'")
}