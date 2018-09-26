
sealed class Consumer<T> {
    abstract fun consume(elem: T)
}

class Printer<T>: Consumer<T>() {
    private var toPrint: T? = null

    fun print() {
        println("Printing $toPrint")
    }

    override fun consume(elem: T) {
        toPrint = elem
    }
}

class Scanner<T>: Consumer<T>() {
    private var toScan: T? = null

    fun scan() {
        println("Scanning $toScan")
    }

    override fun consume(elem: T) {
        toScan = elem
    }
}

fun getConsumer(): Consumer<Number> = Printer()

fun main(args: Array<String>) {
    val consumer = getConsumer()
    consumer.consume(10)

    when(consumer) {
        is Printer -> consumer.print()
        is Scanner -> consumer.scan()
    }

    // TODO: I want consumer to accept below declarations
//    val c1: Consumer<Int> = Printer<Number>()
//    val c2: Consumer<Int> = Scanner<Number>()
//    val c3: Printer<Int> = Printer<Number>()
//    val c4: Scanner<Int> = Scanner<Number>()
}