package nullability

class Client(val personalInfo: PersonalInfo?)
class PersonalInfo(val email: String?)

interface Mailer {
    fun sendMessage(email: String, message: String)
}

/*
Send message if the message, client, personal info and email are not null.
*/
fun sendMessageToClient(client: Client?, message: String?, mailer: Mailer) {

}