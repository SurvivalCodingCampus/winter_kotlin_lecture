package org.example.day5

import java.time.LocalDate

//fun main() {
//    var person1 = Person("홍길동")
//    var person2 = Person("한석봉")
//    val persons: List<Person> = listOf(person1, person2)
//    val personMap: Map<String, Int> = mapOf(
//        person1.name to 20,
//        person2.name to 25,
//    )
//
////    for (person in persons) println(person.name)
//
//    for ((key, value ) in personMap) println("\"${key}의 나이는 ${value}살\"")
//}
class Person(
    val name: String,
    val birthYear: Int
) {
    val age: Int = LocalDate.now().year - birthYear

    
//    var name: String = name
//        set(value) {
//            require(value.isNotBlank()) {
//                throw IllegalArgumentException("이름은 반드시 필요합니다")
//            }
//            field = value
//        }
//
//    init {
//        this.name = name
//    }
}