package org.example.day07

abstract class TangibleAsset(
    name: String,
    price: Int,
    color: String,
) : Asset(name, price, color) {}


abstract class IntangibleAsset(
    name: String,
    price: Int,
    color: String,
    override var weight: Double
) : Asset(name, price, color), Thing {}


abstract class Asset(
    var name: String,
    var price: Int,
    var color: String,
) {}

interface Thing {
    var weight: Double
}