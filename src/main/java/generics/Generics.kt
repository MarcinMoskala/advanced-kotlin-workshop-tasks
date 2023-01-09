package generics

class Box<T>(e: T) {
    var e: T = e
    fun get(): T = e
    fun put(e: T) {
        this.e = e
    }
}
