package day7

class Book(
    name: String,
    price: Int,
    color: String,
    var isbn: String,
) : TangibleAsset(name, price, color)