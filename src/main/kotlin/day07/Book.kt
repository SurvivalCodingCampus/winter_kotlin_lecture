package org.example.day07

class Book(
    name: String,
    price: Int,
    color: String,
    var isbn: String, //고유 값
    override var weight: Double,
) : TangibleAsset(name, price, color)