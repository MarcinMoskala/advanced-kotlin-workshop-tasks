package coroutines

val primes: Sequence<Int> = sequence {
    TODO()
}

// TODO: Delete it and replace it with sequence builder (above)
fun getPrimeNumbers(num: Int): List<Int> {
    var numbers = generateSequence(2) { it + 1 }
    val primes = mutableListOf<Int>()
    repeat(num) {
        val prime = numbers.first()
        primes += prime
        numbers = numbers.drop(1).filter { it % prime != 0 }
    }
    return primes
}