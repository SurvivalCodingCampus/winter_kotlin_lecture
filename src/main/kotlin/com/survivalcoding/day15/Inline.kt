package com.survivalcoding.com.survivalcoding.day15

fun main() {
    println("null".getOrNull(0))
    println("main 시작 ")



    noInline(callback = {
        println("콜백")
    })
    noInline(callback = {
        println("콜백")
    })
    noInline(callback = {
        println("콜백")
    })
    listOf(1, 23, null).map { }
        .filterNotNull()

    val ddd = "null"

    val delistingDate = if (ddd == "null") null else ddd
}

fun noInline(callback: () -> Unit = {}) {
    println("noInline Start")
    callback()
    println("noInline End")
}