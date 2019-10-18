package basics.treeoperations

sealed class Tree<T> {
    override fun toString(): String = when (this) {
        is Leaf -> value.toString()
        is Node -> "($left, $right)"
    }
}

data class Leaf<T>(val value: T) : Tree<T>()
data class Node<T>(val left: Tree<T>, val right: Tree<T>) : Tree<T>()