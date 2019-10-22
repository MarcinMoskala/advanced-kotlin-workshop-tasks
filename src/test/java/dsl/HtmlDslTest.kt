package dsl

import org.junit.Test
import kotlin.test.assertEquals

class HtmlDslTest {

    @Test
    fun createTableTest() {
        @Suppress("SuspiciousCollectionReassignment")
        val html = TableBuilder().apply {
            trs += TrBuilder().apply {
                tds += TdBuilder().apply { text = "A" }
                tds += TdBuilder().apply { text = "B" }
            }
            trs += TrBuilder().apply {
                tds += TdBuilder().apply { text = "C" }
                tds += TdBuilder().apply { text = "D" }
            }
        }
        assertEquals(html, createTable())
    }

//    @Test
//    fun `Table can be created and it is empty by default`() {
//        @Suppress("SuspiciousCollectionReassignment")
//        val expected = TableBuilder()
//        val actual =  table {}
//        assertEquals(expected, actual)
//    }
//
//    @Test
//    fun `Tr can be created and it is empty`() {
//        @Suppress("SuspiciousCollectionReassignment")
//        val expected = TableBuilder().apply {
//            trs += TrBuilder()
//        }
//        val actual =  table {
//            tr {}
//        }
//        assertEquals(expected, actual)
//    }
//
//    @Test
//    fun `Multiple tr can be created`() {
//        @Suppress("SuspiciousCollectionReassignment")
//        val expected = TableBuilder().apply {
//            trs += TrBuilder()
//            trs += TrBuilder()
//        }
//        val actual =  table {
//            tr {}
//            tr {}
//        }
//        assertEquals(expected, actual)
//    }
//
//    @Test
//    fun `Td can be created and it is empty`() {
//        @Suppress("SuspiciousCollectionReassignment")
//        val expected = TableBuilder().apply {
//            trs += TrBuilder().apply {
//                tds += TdBuilder()
//            }
//        }
//        val actual =  table {
//            tr {
//                td {}
//            }
//        }
//        assertEquals(expected, actual)
//    }
//
//    @Test
//    fun dslTestStandard() {
//        @Suppress("SuspiciousCollectionReassignment")
//        val expected = TableBuilder().apply {
//            trs += TrBuilder().apply {
//                tds += TdBuilder().apply { text = "A" }
//                tds += TdBuilder().apply { text = "B" }
//            }
//            trs += TrBuilder().apply {
//                tds += TdBuilder().apply { text = "C" }
//                tds += TdBuilder().apply { text = "D" }
//            }
//        }
//        val actual =  table {
//            tr {
//                td { +"A" }
//                td { +"B" }
//            }
//            tr {
//                td { +"C" }
//                td { +"D" }
//            }
//        }
//        assertEquals(expected, actual)
//    }
//
//    @Test
//    fun dslTestMoreColons() {
//        @Suppress("SuspiciousCollectionReassignment")
//        val expected = TableBuilder().apply {
//            trs += TrBuilder().apply {
//                tds += TdBuilder().apply { text = "A" }
//                tds += TdBuilder().apply { text = "B" }
//                tds += TdBuilder().apply { text = "C" }
//            }
//            trs += TrBuilder().apply {
//                tds += TdBuilder().apply { text = "C" }
//                tds += TdBuilder().apply { text = "D" }
//            }
//        }
//        val actual =  table {
//            tr {
//                td { +"A" }
//                td { +"B" }
//                td { +"C" }
//            }
//            tr {
//                td { +"C" }
//                td { +"D" }
//            }
//        }
//        assertEquals(expected, actual)
//    }
}