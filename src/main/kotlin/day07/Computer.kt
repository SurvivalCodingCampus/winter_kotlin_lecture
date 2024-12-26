package org.example.day07

class Computer(
    name: String,
    price: Int,
    color: String,
    var makerName: String,
    weight: Double,
) : TangibleAsset(name, price, color, weight)