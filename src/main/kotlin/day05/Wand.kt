package day05

/*
지팡이의 이름은 null 일 수 없고, 반드시 3문자 이상이어야 한다
지팡이의 마력은 0.5 이상 100.0 이하여야 한다.
*/
class Wand(name: String, power: Double) {
    var name: String = name
        private set

    var power: Double = power

    init {
        require(name.length >= 3) { "지팡이는 반드시 3문자 이상이어야 합니다" }
        require(power >= 0.5 && power <= 100) { "지팡이 마력은 0.5 이상 100.0 이하여야 합니다" }
    }
}
