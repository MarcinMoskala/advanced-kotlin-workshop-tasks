// TODO: Remove it
@file:Suppress("DEPRECATION", "ObsoleteExperimentalCoroutines")

package coroutines

import kotlinx.coroutines.experimental.*

fun main(args: Array<String>) = runBlocking {
    println("Started!")
    test()
    println("Done.")
    async {  }
}

suspend fun test() {
    delay(1000)
}