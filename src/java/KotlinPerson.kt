package java

class KotlinPerson(
        var name: String,
        var age: Int
) {
    val isMature: Boolean
        get() = age > 18
}