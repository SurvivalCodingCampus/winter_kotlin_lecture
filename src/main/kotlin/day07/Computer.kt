package day07

class Computer(
    name: String,
    price: Int,
    color: String,
    weight: Double,
    val makerName: String,
) : Asset.TangibleAsset(name, price, color, weight)