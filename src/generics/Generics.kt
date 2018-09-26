interface Wild
interface Animal
open class Dog(): Wild, Animal
class Human(): Animal
class Puppy: Dog()
class Hund: Dog()

class Box<T>(e: T) {
    var e: T = e
    fun get(): T = e
    fun put(e: T) { this.e = e }
}
