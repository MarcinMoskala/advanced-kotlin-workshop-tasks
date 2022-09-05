package sendmessage

class MessageService(
    val messageSender: MessageSender
) {
    // TODO: Implement `sendMessage` function here
    // With parameters:
    // * `to` of type `String` and default value "all"
    // * `title` of type `String` and default value ""
    // * `content` of type `String` and default value ""
    // Without result type (or returning `Unit`)
    // Function should get emails using `findEmailAddresses`
    // Then for each email, it should send emails using `messageSender` function `sendEmail`
    // For iterate over emails, use
    // for(email in emails) {
    //     ...
    // }

    private fun findEmailAddresses(to: String): List<EmailAddress> =
        if(to == "all") allEmailAddresses
        else allEmailAddresses.filter { it.address == to }

    private val allEmailAddresses = listOf(
        EmailAddress("alex@gmail.com"),
        EmailAddress("jake@gmail.com"),
        EmailAddress("leon@gmail.com"),
        EmailAddress("ally@gmail.com"),
    )
}

data class EmailAddress(val address: String)

interface MessageSender {
    fun sendEmail(email: EmailAddress, title: String, content: String)
}

data class Email(
    val email: EmailAddress,
    val title: String,
    val content: String
)
