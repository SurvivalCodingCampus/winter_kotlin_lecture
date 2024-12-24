package day7

abstract class TangibleAsset(
    name: String,
    var price: Int,
    var color: String,
    final override var weight: Double,
) : Asset(name), Thing