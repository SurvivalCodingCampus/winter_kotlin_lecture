package com.survivalcoding.day07

class Book(
    name: String,
    price: Int,
    color: String,
    var isbn: String,
    weight: Double,
) : TangibleAsset(name, price, color, weight)