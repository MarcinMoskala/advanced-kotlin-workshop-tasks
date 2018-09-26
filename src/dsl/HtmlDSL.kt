package dsl

@DslMarker
annotation class HtmlTagMarker

@HtmlTagMarker
open class Tag(val name: String) {
    private val children = mutableListOf<Tag>()
    protected fun <T : Tag> doInit(child: T, childInitialized: T.() -> Unit) {
        children += child.apply(childInitialized)
    }

    override fun toString() = "<$name>${children.joinToString("")}</$name>"

    operator fun String.unaryPlus() = doInit(TextTag(this), {})
}

fun table(init: TABLE.() -> Unit): TABLE = TABLE().apply(init)

class TABLE : Tag("table") {
    fun tr(init: TR.() -> Unit) = doInit(TR(), init)
}

class TR : Tag("tr") {
    fun td(init: TD.() -> Unit) = doInit(TD(), init)
}

class TD : Tag("td")

class TextTag(private val text: String) : Tag("TextTag") {
    override fun toString() = text
}

fun createTable() = table {
    tr {
        for (i in 1..2) {
            td {
                +"This is row $i"
            }
        }
    }
}

fun main(args: Array<String>) {
    println(createTable()) //<table><tr><td>This is row 1</td><td>This is row 2</td></tr></table>
}
