package day07

class Book(
    name: String,
    price: Int,
    color: String,
    weight: Double,
    val isbn: String,
) : Asset.TangibleAsset(name, price, color, weight)