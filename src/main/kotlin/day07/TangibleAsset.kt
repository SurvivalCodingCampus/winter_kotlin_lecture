package day07

abstract class TangibleAsset(
    name: String,
    price: Int,
    var color: String,
): Asset(name, price), Thing {

}