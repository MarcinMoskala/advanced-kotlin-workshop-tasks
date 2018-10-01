package basics

// TODO: Clean it up
abstract class Tree {
    override fun toString(): String {
        return treeToString(this, StringBuilder()).toString()
    }
}
class Leaf(val value: String): Tree()
class Node(val left: Tree, val right: Tree): Tree()

private fun treeToString(tree: Tree, sb: StringBuilder): StringBuilder {
    if(tree is Leaf) {
        val leaf = tree as Leaf
        sb.append(leaf.value)
    } else if(tree is Node) {
        val node = tree as Node
        treeToString(node.left, sb)
        sb.append(", ")
        treeToString(node.right, sb)
    }
    return sb
}

// Extra TODO
// size, count, contains (with deep search)
// Make a sorted tree with plus operator and balancing and treeOf