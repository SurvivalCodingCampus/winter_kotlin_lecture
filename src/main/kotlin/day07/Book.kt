package org.example.day07

class Book(
    name: String,
    price: Int,
    weight: Double,
    color: String,
    var isbn: String,
) : TangibleAsset(name, price, weight, color)