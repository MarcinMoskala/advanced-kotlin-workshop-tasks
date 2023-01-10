package types

import kotlin.random.Random

open class Animal
class Dog : Animal()

fun main() {
    val dog: Dog = Dog()
    val nullableDog: Dog? = if (Random.nextBoolean()) Dog() else null
    val animal: Animal = Animal()
    val nullableAnimal: Animal? = if (Random.nextBoolean()) Animal() else null
}

fun consumeDog(dog: Dog) {}
fun consumeNullableDog(dog: Dog?) {}
fun consumeAnimal(animal: Animal) {}
fun consumeNullableAnimal(animal: Animal?) {}
fun consumeAny(any: Any) {}
fun consumeNullableAny(any: Any?) {}
fun consumeNothing(nothing: Any) {}
fun consumeNullableNothing(nothing: Any?) {}
