package types

import kotlin.random.Random




































fun main() {
    val a: Int = if (Random.nextBoolean()) 42 else 10

    val message: String = produceMessage() ?: "ABC"

    val grade: Char = when (result) {
        in 0 until 50 -> 'F'
        in 50 until 65 -> 'D'
        in 65 until 80 -> 'C'
        in 80 until 90 -> 'B'
        in 90..100 -> 'A'
        else -> 'X'
    }
}

val result = Random.nextInt(1, 100)
fun produceMessage(): String? = null
