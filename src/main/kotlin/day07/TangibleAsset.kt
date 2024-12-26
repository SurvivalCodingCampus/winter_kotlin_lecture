package day07

abstract class TangibleAsset(
    name: String,
    price: Int,
    color: String,
    override var weight: Double
) : Asset(name, price), Thing {
}

