import org.junit.After
import org.junit.Test
import sendmessage.Email
import sendmessage.EmailAddress
import sendmessage.MessageSender
import sendmessage.MessageService
import kotlin.reflect.full.functions
import kotlin.reflect.typeOf
import kotlin.test.assertEquals
import kotlin.test.assertNotNull

class SendMessageTest {
    private val sender = FakeMessageSender()
    private val messageService: MessageService = MessageService(sender)

    @After
    fun cleanup() {
        sender.clear()
    }

    @Test
    fun `function with correct name exist`() {
        val function = MessageService::class.functions.find { it.name == "sendMessage" }
        assertNotNull(function) { "You must define a function with name sendMessage" }
    }

    @Test
    fun `the function has 3 parameters (+ receiver)`() {
        val function = MessageService::class.functions.find { it.name == "sendMessage" }
        assertNotNull(function) { "You must define a function with name sendMessage" }
        assertEquals(4, function.parameters.size, "Function should have three parameters" )
    }

    @Test
    fun `the function parameters has correct types`() {
        val function = MessageService::class.functions.find { it.name == "sendMessage" }
        assertNotNull(function) { "You must define a function with name sendMessage" }
        assertEquals(typeOf<String>(), function.parameters[1].type)
        assertEquals(typeOf<String>(), function.parameters[2].type)
        assertEquals(typeOf<String>(), function.parameters[3].type)
    }

    @Test
    fun `the function has correct result type`() {
        val function = MessageService::class.functions.find { it.name == "sendMessage" }
        assertNotNull(function) { "You must define a function with name sendMessage" }
        assertEquals(typeOf<Unit>(), function.returnType)
    }

    @Test
    fun `the function parameters have correct names`() {
        val function = MessageService::class.functions.find { it.name == "sendMessage" }
        assertNotNull(function) { "You must define a function with name sendMessage" }
        assertEquals("to", function.parameters[1].name)
        assertEquals("title", function.parameters[2].name)
        assertEquals("content", function.parameters[3].name)
    }

    @Test
    fun `all parameters of the function have default arguments`() {
        val function = MessageService::class.functions.find { it.name == "sendMessage" }
        assertNotNull(function) { "You must define a function with name sendMessage" }
        assert(function.parameters[1].isOptional)
        assert(function.parameters[2].isOptional)
        assert(function.parameters[3].isOptional)
    }

    @Test
    fun `calling the function with no arguments sends empty message to everyone`() {
        val function = messageService::class.functions.find { it.name == "sendMessage" }
        assertNotNull(function) { "You must define a function with name sendMessage" }
        function.callBy(mapOf(function.parameters[0] to messageService))
        assertEquals(listOf(
            Email(email=EmailAddress(address="alex@gmail.com"), title="", content=""),
            Email(email=EmailAddress(address="jake@gmail.com"), title="", content=""),
            Email(email=EmailAddress(address="leon@gmail.com"), title="", content=""),
            Email(email=EmailAddress(address="ally@gmail.com"), title="", content="")
        ), sender.messagesSent)
    }

    @Test
    fun `calling the function with arguments sends message to concrete email`() {
        val function = messageService::class.functions.find { it.name == "sendMessage" }
        assertNotNull(function) { "You must define a function with name sendMessage" }
        function.callBy(mapOf(
            function.parameters[0] to messageService,
            function.parameters[1] to "jake@gmail.com",
            function.parameters[2] to "Some title",
            function.parameters[3] to "Some content",
        ))
        assertEquals(listOf(
            Email(email=EmailAddress(address="jake@gmail.com"), title="Some title", content="Some content"),
        ), sender.messagesSent)
    }

    class FakeMessageSender: MessageSender {
        var messagesSent = listOf<Email>()
            private set

        override fun sendEmail(email: EmailAddress, title: String, content: String) {
            messagesSent += Email(email, title, content)
        }

        fun clear() {
            messagesSent = emptyList()
        }
    }
}
