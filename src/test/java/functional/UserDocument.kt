package functional.document

class User(
    val id: String,
    val name: String,
    val surname: String,
    val age: Int,
    val tokens: List<String>
)

class UserDocument(
    val userId: String,
    val firstName: String,
    val lastName: String,
    val age: Int,
    val tokens: List<String>
)

fun User.toUserDocument(): UserDocument = TODO()

fun UserDocument.toUser(): User = TODO()