package org.example.day5

fun main() {
    var person1 = Person("홍길동")
    var person2 = Person("한석봉")
    val persons: List<Person> = listOf(person1, person2)

    for (person in persons) println(person.name)
}
class Person(
    name: String
) {
    var name: String = name
        set(value) {
            require(value.isNotBlank()) {
                throw IllegalArgumentException("이름은 반드시 필요합니다")
            }
            field = value
        }

    init {
        this.name = name
    }
}