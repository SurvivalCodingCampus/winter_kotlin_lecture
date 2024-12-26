package day07


// 최상위 클래스
sealed class Asset(
    var name: String,
    var price: Int
) {
    // 유형 자산
    abstract class TangibleAsset(
        name: String,
        price: Int,
        var color: String,
        override var weight: Double,
    ) : Asset(name, price), Thing

    // 무형 자산
    abstract class IntangibleAsset(
        name: String,
        price: Int,
    ) : Asset(name, price)
}

