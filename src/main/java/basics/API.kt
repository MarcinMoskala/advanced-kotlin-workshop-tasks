package basics

import generics.Response

class StudentController(
    val studentRepository: StudentRepository,
    val analyticsRepository: AnalyticsRepository
) {

    @GetMapping("/student/{id}")
    fun getUser(@PathVariable id: Long): StudentAPI {
        TODO()
    }

    @GetMapping("/student")
    fun getUsers(): List<StudentAPI> {
        TODO()
    }
}

data class StudentAPI(
    val name: String,
    val surname: String
)

@Entity
data class StudentEntity(
    @Id @GeneratedValue
    val id: Long = -1,
    val firstName: String,
    val lastName: String
)

interface StudentRepository {

    fun findStudent(id: Long): StudentEntity?
    fun findStudentResult(id: Long): Response<StudentEntity, NotFoundException>
    fun getAllStudents(): List<StudentEntity>
}

object NotFoundException: Throwable()

interface AnalyticsRepository {

    fun getStudentByIdCount(id: Long): Int
    fun setStudentByIdCount(id: Long, count: Int)
}

data class ApiError(val code: Int, override val message: String) : Throwable(message)

annotation class Entity
annotation class Id
annotation class GeneratedValue
annotation class GetMapping(val path: String)
annotation class PathVariable