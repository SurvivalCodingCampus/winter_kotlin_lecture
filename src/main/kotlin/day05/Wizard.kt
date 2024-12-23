package day05

import day05.Wand.Companion

/*마법사나 지팡이의 이름은 null 일 수 없고, 반드시 3문자 이상이어야 한다
지팡이의 마력은 0.5 이상 100.0 이하여야 한다.
마법사의 지팡이는 null 일 수 없다.
마법사의 MP는 0 이상이어야 한다.
HP가 음수가 되는 상황에서는 대신 0을 설정 되도록 한다. (에러 아님)
*/
class Wizard(
    val initialName: String,
    val initialHp: Int,
    val mp: Int,
    val wand: Wand,)
{
    init {
        validateName(initialName)
        require(mp >= 0) {"마법사의 mp는 0 이상이어야 한다"}
    }

    companion object {
        private val NAME_LENGTH = 3

        private fun validateName(name: String) {
            require(name.length >= NAME_LENGTH) {"마법사의 이름은 $NAME_LENGTH 문자 이상이어야 한다"}
        }
    }

    var name: String = initialName
        set(value) {
            validateName(value)
            field = value                       //field는 getter, setter에서만 사용할 수 있는 내부 저장소로 속성 값 저장.
        }

   var hp: Int = if (initialHp < 0) 0 else initialHp

}

fun main() {
    val wand = Wand(name = "지팡이", power = 80.0)
    val wizard = Wizard(initialName = "간달프", initialHp = -10, mp = 30, wand = wand)

    println(wizard.initialHp)
    println(wizard.hp)
}