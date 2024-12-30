package org.example.day09

fun main() {
    val names: List<String> = listOf("Seth", "Kathy", "Lars")
    val sortedNames = names.sortedBy { it.length }
    println(sortedNames)

}

// depp copy 비교 ===