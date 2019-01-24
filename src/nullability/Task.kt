package nullability

import org.junit.Test
import kotlin.test.assertEquals

class Client(val personalInfo: PersonalInfo?)
class PersonalInfo(val email: String?)

interface Mailer {
    fun sendMessage(email: String, message: String)
}

/*
Rewrite Java method 'MessageUtil.sendMessageToClient' in Kotlin in 2-3 lines.
*/
fun sendMessageToClient(client: Client?, message: String?, mailer: Mailer) {
    // TODO
}

@Suppress("FunctionName")
internal class BasicsTests {

    class MailCollector(): Mailer {
        data class Mail(val email: String, val message: String)

        var emails = listOf<Mail>()

        override fun sendMessage(email: String, message: String) {
            emails += Mail(email, message)
        }
    }

    @Test
    fun `When client is null, email we do not send email`() {
        val mailer = MailCollector()
        sendMessageToClient(null, "AAA", mailer)
        assertEquals(emptyList(), mailer.emails)
    }

    @Test
    fun `When message is null, we do not send email`() {
        val mailer = MailCollector()
        sendMessageToClient(Client(PersonalInfo("AAA")), null, mailer)
        assertEquals(emptyList(), mailer.emails)
    }

    @Test
    fun `When personal info is null, we do not send email`() {
        val mailer = MailCollector()
        sendMessageToClient(Client(null), "AAA", mailer)
        assertEquals(emptyList(), mailer.emails)
    }

    @Test
    fun `When email address is null, we do not send email`() {
        val mailer = MailCollector()
        sendMessageToClient(Client(PersonalInfo(null)), null, mailer)
        assertEquals(emptyList(), mailer.emails)
    }

    @Test
    fun `Sends messages correctly for correct values`() {
        val mailer = MailCollector()
        sendMessageToClient(Client(PersonalInfo("AAA")), "BBB", mailer)
        assertEquals(listOf(MailCollector.Mail("AAA", "BBB")), mailer.emails)
    }
}