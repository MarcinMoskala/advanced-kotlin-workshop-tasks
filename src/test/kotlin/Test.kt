import javax.swing.text.View

var listeners: List<Listener> = listOf()
fun addListener(listener: Listener) {
    listeners += listener
}
private typealias Listener = (id: Int, current: View, parent: View)->Unit

fun main() {

}