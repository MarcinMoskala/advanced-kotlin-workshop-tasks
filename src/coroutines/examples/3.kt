package coroutines.examples

import kotlinx.coroutines.experimental.GlobalScope
import kotlinx.coroutines.experimental.delay
import kotlinx.coroutines.experimental.launch
import kotlinx.coroutines.experimental.runBlocking
import org.junit.jupiter.api.Test

fun main(args: Array<String>) = runBlocking {
    GlobalScope.launch {
        delay(1000L)
        println("World!")
    }
    println("Hello,")
    delay(2000L)
}

class MyTest {
    @Test
    fun testMySuspendingFunction() = runBlocking {
        //...
    }
}