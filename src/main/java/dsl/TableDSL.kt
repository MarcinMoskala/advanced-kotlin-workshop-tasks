package dsl

fun createTable(): TableBuilder {
    // TODO: This is how I would prefer to print it
//return table {
//    tr {
//      td { +"A" }
//      td { +"B" }
//    }
//    tr {
//      td { +"C" }
//      td { +"D" }
//    }
//}
    val td1 = TdBuilder()
    td1.text = "A"
    val td2 = TdBuilder()
    td2.text = "B"

    val tr1 = TrBuilder()
    tr1.tds += td1
    tr1.tds += td2

    val td3 = TdBuilder()
    td3.text = "C"
    val td4 = TdBuilder()
    td4.text = "D"

    val tr2 = TrBuilder()
    tr2.tds += td3
    tr2.tds += td4

    val html = TableBuilder()
    html.trs += tr1
    html.trs += tr2
    return html
}

fun main() {
    println(createTable()) //<table><tr><td>This is row 1</td><td>This is row 2</td></tr></table>
}

data class TableBuilder(var trs: List<TrBuilder> = emptyList()) {
    override fun toString(): String = "<table>${trs.joinToString(separator = "")}</table>"
}
data class TrBuilder(var tds: List<TdBuilder> = emptyList()) {
    override fun toString(): String = "<tr>${tds.joinToString(separator = "")}</tr>"
}
data class TdBuilder(var text: String = "") {
    override fun toString(): String = "<td>$text</td>"
}