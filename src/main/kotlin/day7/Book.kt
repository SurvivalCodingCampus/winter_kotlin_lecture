package org.example.day7

class Book(
    name: String,
    price: Int,
    color: String,
    val isbn: String,
    weight: Double,
): TangibleAsset(name, price, color, weight) {

}