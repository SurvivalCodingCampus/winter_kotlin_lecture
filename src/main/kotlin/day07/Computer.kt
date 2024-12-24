package org.example.day07

class Computer(
    name: String,
    price: Int,
    weight: Double,
    color: String,
    var makerName: String,
) : TangibleAsset(name, price, weight, color)