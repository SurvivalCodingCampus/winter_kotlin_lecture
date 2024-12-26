package day07

class Book(
    name: String,
    price: Int,
    color: String,
    weight: Double,
    var isbn: String,
) : TangibleAsset(name, price, color, weight) {
}