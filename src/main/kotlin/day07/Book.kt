package day07

class Book(
    override var name: String,
    override var price: Int,
    override var color: String,
    override var weight: Double,
    var isbn: String,
) : TangibleAsset()