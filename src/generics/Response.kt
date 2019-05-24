package generics

sealed class Response<R, E>
class Success<R, E>(val value: R): Response<R, E>()
class ErrorResponse<R, E>(val error: E): Response<R, E>()

/* TODO:
   I would like to use it this way:

fun processResponseInt(response: Response<Int, String>) { /*...*/ }
fun processResponseString(response: Response<String, Throwable>) { /*...*/ }

fun usage() {
    processResponseInt(Success(1))
    processResponseInt(ErrorResponse("ERROR"))
    processResponseString(Success("ERROR"))
    processResponseString(ErrorResponse(Error("ERROR")))

    val rs1 = Success(1)
    val re1 = ErrorResponse(Error())
    val re2 = ErrorResponse("Error")

    val rs1asNumber: Success<Number> = rs1
    val rs1asAny: Success<Any> = rs1

    val re1asThrowable: ErrorResponse<Throwable> = re1
    val re1asAny: ErrorResponse<Any> = re1

    val r1: Response<Int, Error> = rs1
    val r2: Response<Int, Error> = re1

    val r3: Response<Int, String> = rs1
    val r4: Response<Int, String> = re2

    val r5: Response<Any, Throwable> = rs1
    val r6: Response<Any, Throwable> = re1

    val s = Success(String())
    val s1: Success<CharSequence> = s
    val s2: Success<Any> = s

    val e = ErrorResponse(Error())
    val e1: ErrorResponse<Throwable> = e
    val e2: ErrorResponse<Any> = e
}
 */