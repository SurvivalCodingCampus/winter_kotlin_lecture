package org.example.day7

abstract class TangibleAsset(
    name: String,
    price: Int,
    var color: String,
) : Asset(name, price) {

}