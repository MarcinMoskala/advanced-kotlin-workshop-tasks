import kotlin.test.assertEquals

inline fun <reified T: Throwable> assertThrows(message: String? = null, body: ()->Unit): T {
    try {
        body()
    } catch (throwable: Throwable) {
        assert(throwable is T) { "The type of caught exception is not correct. It is $throwable" }
        if(message != null) assertEquals(message, throwable.message)
        return throwable as T
    }
    throw AssertionError("Body does not throw exception as expected")
}