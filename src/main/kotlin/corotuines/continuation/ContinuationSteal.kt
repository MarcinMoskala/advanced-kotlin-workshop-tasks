@file:UseExperimental(ExperimentalCoroutinesApi::class)

package continuation

import kotlinx.coroutines.*
import kotlin.coroutines.Continuation
import kotlin.coroutines.resume

fun main(): Unit = runBlocking<Unit> {
    val cont = continuationSteal<String>()
    delay(1000)
    cont?.resume("This is some text")
}

fun <T> continuationSteal(console: Console = Console()): Continuation<T>? = runBlocking {
    var continuation: Continuation<T>? = null
    GlobalScope.launch(Dispatchers.Unconfined) {
        console.println("Before")
        TODO()
        console.println("After")
    }
    continuation
}

open class Console {

    open fun println(text: Any?) {
        kotlin.io.println(text)
    }
}