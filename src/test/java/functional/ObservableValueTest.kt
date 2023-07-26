package functional

import org.junit.Test
import kotlin.test.assertEquals

class ObservableValue<T>(initial: T) {
    var value: T = initial
    
    fun observe(observer: (T) -> Unit) {
        TODO()
    }
}

class ObservableValueTest {

    @Test
    fun `should behave like regular value`() {
        val i = ObservableValue<Int?>(null)
        assertEquals(null, i.value)
        i.value = 1
        assertEquals(1, i.value)
        i.value = 2
        assertEquals(2, i.value)
    }

    @Test
    fun `should call observer when value changes`() {
        val o = ObservableValue<String>("A")
        val called = mutableListOf<String>()
        o.observe { called += it }
        o.value = "B"
        o.value = "C"
        o.value = "D"
        assertEquals(listOf("B", "C", "D"), called)
    }

    @Test
    fun `should call observers when value changes`() {
        val o1 = ObservableValue<String>("A")
        val o2 = ObservableValue<String>("A")
        val history1 = mutableListOf<String>()
        o1.observe { history1 += it }
        o1.value = "B"
        val history2 = mutableListOf<String>()
        o1.observe { history2 += it }
        val history3 = mutableListOf<String>()
        o2.observe { history3 += it }
        o1.value = "C"
        o1.value = "D"
        assertEquals(listOf("B", "C", "D"), history1)
        assertEquals(listOf("C", "D"), history2)
        assertEquals(listOf(), history3)
    }
}
