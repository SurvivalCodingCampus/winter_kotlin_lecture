package org.example.day05

fun main() {
    val personList = listOf(
        PersonBType("홍길동", 20),
        PersonBType("한석봉", 25),
    )

    val personMap = personList.associate {
        it.name to it.age
    }

    for (person in personList) {
        println(person.name)
    }

    for ((name, age) in personMap) {
        println("${name}의 나이는 ${age}살")
    }
}

class PersonBType(
    val name: String,
    val age: Int,
)