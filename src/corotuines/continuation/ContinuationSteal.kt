@file:UseExperimental(ExperimentalCoroutinesApi::class)
package continuation

import kotlinx.coroutines.*
import kotlin.coroutines.Continuation
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

fun main(): Unit = runBlocking<Unit> {
    val cont = continuationSteal<String>()
    delay(1000)
    cont?.resume("This is some text")
}

fun <T> continuationSteal(console: Console = Console()): Continuation<T>? = runBlocking {
    var continuation: Continuation<T>? = null
    GlobalScope.launch(Dispatchers.Unconfined) {
        console.println("Before")
        val test = suspendCoroutine<T> { cont ->
            continuation = cont
        }
        console.println("After")
    }
    continuation
}

open class Console {

    open fun println(text: Any?) {
        kotlin.io.println(text)
    }
}