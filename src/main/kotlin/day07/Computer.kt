package org.example.day07

class Computer(
    name: String,
    price: Int,
    color: String,
    val makerName: String,
    weight: Double
): TangibleAsset(name, price, color, weight) {

}