package com.survivalcoding.com.survivalcoding.day07

abstract class TangibleAsset(
    name: String,
    price: Int,
    var color: String,
    override var weight: Double,
) : Asset(name, price), Thing {

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as TangibleAsset

        if (weight != other.weight) return false
        if (color != other.color) return false

        return true
    }

    override fun hashCode(): Int {
        var result = weight.hashCode()
        result = 31 * result + color.hashCode()
        return result
    }
}