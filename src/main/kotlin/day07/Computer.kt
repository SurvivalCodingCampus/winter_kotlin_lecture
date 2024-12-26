package day07

class Computer (
    name: String,
    price: Int,
    color: String,
    weight: Double,
    var makerName: String,
) : TangibleAsset(name, price, color, weight) {

}