package delegates

import org.junit.jupiter.api.Test
import kotlin.properties.ReadWriteProperty
import kotlin.system.measureTimeMillis

fun <T> mutableLazy(initializer: () -> T): ReadWriteProperty<Any?, T> = TODO()

@Suppress("FunctionName")
class SieveTests {

    @Test
    fun `I don't have to wait if I changed value first`() {
        val time = measureTimeMillis {
            var game: Game? by mutableLazy { readGameFromSave() }
            game = Game()
            print(game)
        }
        assert(time in 0..100)
    }

    @Test
    fun `I have to wait if I changed value first`() {
        val time = measureTimeMillis {
            val game: Game? by mutableLazy { readGameFromSave() }
            print(game)
        }
        assert(time in 450..550)
    }

    private class Game()

    private fun readGameFromSave(): Game? {
        Thread.sleep(500)
        return Game()
    }
}
