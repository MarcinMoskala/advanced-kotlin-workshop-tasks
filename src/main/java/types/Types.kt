package types

import kotlin.random.Random
import kotlin.system.exitProcess

fun fail(): Unit {
    throw Error()
}

fun main() {
    val f: ()->Unit = {
        10
    }
    println(f()) // 10

    val n = null
    val s: String? = n
    val i: Int? = n
    val c: Char? = n

    val a: Int = if (Random.nextBoolean()) 42 else throw Error()

    val message: String = produceMessage() ?: throw Error()

    val grade: Char = when (result) {
        in 0 until 50 -> 'F'
        in 50 until 65 -> 'D'
        in 65 until 80 -> 'C'
        in 80 until 90 -> 'B'
        in 90..100 -> 'A'
        else -> throw Error()
    }
}

val result = Random.nextInt(1, 100)
fun produceMessage(): String? = null
