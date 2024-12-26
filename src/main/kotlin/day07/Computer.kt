package day07

class Computer(
    name: String,
    price: Int,
    color: String,
    var makerName: String,
): TangibleAsset(name, price, color) {
    override var weight: Double = 0.0
        get() = field
        set(value) {
            field = if(value < 0.0) throw IllegalArgumentException("컴퓨터의 무게가 음수일리 없습니다.") else value
        }
}