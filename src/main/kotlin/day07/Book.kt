package org.example.day07

class Book(
    name: String,
    price: Int,
    color: String,
    var isbn: String,
    weight: Double
) : TangibleAsset(name, price, color) {

}

class Computer(
    name: String,
    price: Int,
    color: String,
    var makerName: String,
    weight: Double,
) : TangibleAsset(name, price, color) {

}




