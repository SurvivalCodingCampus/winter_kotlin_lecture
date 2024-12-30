package org.example.day09

fun main() {
    val nums = mutableListOf<Int>()

    // Int 생략 가능
    // val nums = mutableListOf(1, 2 ,3)

    // Error!!
    // val nums = mutableListOf<String>()
    nums.add(10)

//    ver1
//    val pocket = Pocket()
//
//    pocket.put("아무거나")
//
//    println(pocket.get())

//    ver2
//    val pocket = Pocket<Int>()
//
//    pocket.put(1)
//
//    println(pocket.get())

}