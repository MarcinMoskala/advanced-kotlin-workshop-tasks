package dsl

class HtmlDsl

fun createTable(): HtmlDsl = TODO()
//table {
//    tr {
//        for (i in 1..2) {
//            td {
//                +"This is row $i"
//            }
//        }
//    }
//}

fun main(args: Array<String>) {
    println(createTable()) //<table><tr><td>This is row 1</td><td>This is row 2</td></tr></table>
}
