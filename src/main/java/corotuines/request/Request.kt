package corotuines.request

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope

/*
   TODO: This function should return the best student on the [semester].
 */
suspend fun getBestStudent(semester: String, repo: StudentsRepository): Student = TODO()

data class Student(val id: Int, val result: Double, val semester: String)

interface StudentsRepository {
    suspend fun getStudentIds(semester: String): List<Int>
    suspend fun getStudent(id: Int): Student
}
