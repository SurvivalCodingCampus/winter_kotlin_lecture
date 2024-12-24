package org.example.day07

class Book(
    name: String,
    price: Int,
    color: String,
    var isbn: String,
) : TangibleAsset(name, price, color)