package day07


// 최상위 클래스
sealed class Asset(
    var name: String,
    var price: Int,
    var color: String
) {
    // 유형 자산
    abstract class TangibleAsset(
        name: String,
        price: Int,
        color: String,
        override var weight: Double,
    ) : Asset(name, price, color), Thing

    // 무형 자산
    abstract class IntangibleAsset(
        name: String,
        price: Int,
        color: String
    ) : Asset(name, price, color)
}

