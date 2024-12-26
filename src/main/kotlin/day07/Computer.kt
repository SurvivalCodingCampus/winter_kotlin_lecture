package com.survivalcoding.day07

class Computer(
    name: String,
    price: Int,
    color: String,
    var makerName: String,
    weight: Double,
) : TangibleAsset(name, price, color, weight)


fun main() {
    Computer("", 11, "red", "삼성", 3.3)
    Book("", 11, "red", "삼성", 3.3)
//    TangibleAsset("", 11, "red", "삼성")
}