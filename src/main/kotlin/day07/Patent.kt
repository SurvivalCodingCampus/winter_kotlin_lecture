package day07

class Patent(
    override var name: String,
    override var price: Int,
) : IntangibleAsset()