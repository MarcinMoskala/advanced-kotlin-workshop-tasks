package basics

interface Person {
    val name: String
    val canBuyAlcohol: Boolean

    // Says hello. Example: "Hello, I am Ben"
    fun sayHello()

    // Cheers another person: Example: "Hello Jordan, how are you?"
    fun cheer(person: Person)
}

// TODO: Implement here class Businessman

// TODO: Implement here class Student

fun main(args: Array<String>) {
    val businessman: Person = TODO("Use Businessman constructor here once it is implemented")
    val student: Person = TODO("Use Businessman constructor here once it is implemented")

    businessman.sayHello()
    student.sayHello()

    businessman.cheer(student)
    student.cheer(businessman)

    fun sayIfCanBuyAlcohol(person: Person) {
        val modal = if(person.canBuyAlcohol) "can" else "can't"
        println("${businessman.name} $modal buy alcohol")
    }

    sayIfCanBuyAlcohol(businessman)
    sayIfCanBuyAlcohol(student)
}