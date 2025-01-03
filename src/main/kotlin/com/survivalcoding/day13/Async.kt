package com.survivalcoding.com.survivalcoding.day13

fun main() {
    println(Thread.currentThread())

    Thread {
        println(Thread.currentThread())
        Thread.sleep(5000)
        println("쿵")
    }.start()


    Thread {
        println(Thread.currentThread())
        println("짝")
    }.start()
}