package org.example.day07

import Thing

abstract class TangibleAsset(
    name: String,
    var price: Int,
    var color: String,
    override var weight: Double,
) : Asset(name), Thing