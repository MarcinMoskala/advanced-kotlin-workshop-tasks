package functional

fun repeat(times: Int, action: () -> Unit) {

}

fun main(args: Array<String>) {
    repeat(5) { print("A") } // AAAAA

//    var i = 1
//    loop {
//        print("A")
//        i *= 2
//        if(i > 1000) {
//            // break
//        }
//    }
}