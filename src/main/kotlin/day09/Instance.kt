package day09

import day06.Hero

fun main() {
    val person = Person("test", 30)
    val person1 = Person("test", 30)

    println(person.hashCode() == person1.hashCode())
    println(person.hashCode() == person1.hashCode())
}

data class Person(
    val name: String,
    val age: Int
) {

    override fun hashCode(): Int {
        return super.hashCode()
    }
}
