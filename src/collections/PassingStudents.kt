package collections

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

fun List<Student>.makePassingStudentsListText(): String = this
        .filter { it.pointsInSemester > 15 && it.result >= 50 }
        .sortedWith(compareBy({ it.surname }, { it.name }))
        .joinToString(separator = "\n") {
            "${it.name} ${it.surname}, ${it.result}"
        }


@Suppress("FunctionName")
class PassingStudentsListTest : StudentsTests() {

    @Test
    fun `Single student that matches criteria is displayed`() {
        val text = listOf(internshipStudent).makePassingStudentsListText()
        val expected = "Marc Smith, 87.0"
        assertEquals(expected, text)
    }

    @Test
    fun `Single student with too low result doesn't get internship`() {
        val text = listOf(studentNotPassingBecauseOfResult).makePassingStudentsListText()
        assertEquals("", text)
    }

    @Test
    fun `15 points is not acceptable`() {
        val student = Student("Noely", "Peterson", 81.0, 15)
        val text = listOf(student).makePassingStudentsListText()
        assertEquals("", text)
    }

    @Test
    fun `result 50 points is acceptable`() {
        val student = Student("Noely", "Peterson", 50.0, 25)
        val text = listOf(student).makePassingStudentsListText()
        assertEquals("Noely Peterson, 50.0", text)
    }

    @Test
    fun `Single student with not enough doesn't get internship`() {
        val text = listOf(studentNotPassingBecauseOfPoints).makePassingStudentsListText()
        assertEquals("", text)
    }

    @Test
    fun `Complex test`() {
        val text = allStudents.makePassingStudentsListText()
        val expected = """
            Ester Adams, 81.0
            Dior Angel, 88.5
            Oregon Dart, 85.5
            Jack Johnson, 85.3
            James Johnson, 85.2
            Jon Johnson, 85.1
            Jamme Lannister, 80.0
            Naja Marcson, 100.0
            Alex Nolan, 86.0
            Ron Peters, 89.0
            Noe Peterson, 91.0
            Noely Peterson, 91.0
            Harry Potter, 80.0
            Marc Smith, 87.0
        """.trimIndent()
        assertEquals(expected, text)
    }

}