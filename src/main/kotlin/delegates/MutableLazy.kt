@file:JvmName("Mutable")
package delegates

import kotlin.properties.ReadWriteProperty

fun <T> mutableLazy(initializer: () -> T): ReadWriteProperty<Any?, T> = TODO()