package org.example.day13

object WeatherCallback

fun WeatherCallback.tomorrow(callback: (String) -> Unit) {
    Thread.sleep(2000)
    callback("맑음")
}

fun main() {
    WeatherCallback.tomorrow { data ->
        println("내일 날씨는 $data")
    }
}