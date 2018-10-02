// TODO: Remove it
@file:Suppress("DEPRECATION", "ObsoleteExperimentalCoroutines")

package coroutines

import kotlinx.coroutines.experimental.delay
import kotlinx.coroutines.experimental.launch
import kotlinx.coroutines.experimental.runBlocking

fun main(args: Array<String>) = runBlocking {
    println("Started!")
    test()
    println("Done.")
}

suspend fun test() {
    delay(1000)
}