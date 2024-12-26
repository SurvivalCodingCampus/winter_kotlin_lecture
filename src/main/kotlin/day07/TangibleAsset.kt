package org.example.day07

abstract class TangibleAsset(
    override var name: String,
    override var price: Int,
    override var weight: Double,
    var color: String
) : Asset(), Thing