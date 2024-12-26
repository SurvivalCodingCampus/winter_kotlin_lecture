package day07

class Computer(
    override var name: String,
    override var price: Int,
    override var color: String,
    override var weight: Double,
    var makerName: String,
) : TangibleAsset()