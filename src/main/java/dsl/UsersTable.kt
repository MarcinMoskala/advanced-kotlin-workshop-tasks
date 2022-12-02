package dsl

data class User(val id: String, val name: String, val points: Int, val category: String)

fun usersTable(users: List<User>): TableBuilder = TODO()
