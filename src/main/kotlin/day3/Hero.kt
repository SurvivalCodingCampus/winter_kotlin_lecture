package day3

class Hero(
    var name: String,
    var maxHp: Int = 100,
    var hp: Int = maxHp,
) {
    fun attack() {}

    fun defend() {}

    fun flee() {}

    fun rest() {
        hp = maxHp
        println("${name}은 잠을 자고 회복했다: $hp")
    }
}

