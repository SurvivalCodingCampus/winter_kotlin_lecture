package org.example.day06

object ErrorMsgWeapon {
    const val NANE_LENGTH_ERROR = "무기의 이름은 3글자 이상이어야 합니다."
}

// todo: 추상 클래스로 변경 필요
open class Weapon(
    name: String
) {
    var name: String = name
        set(value) {
            require(value.length >= 3) { ErrorMsgWeapon.NANE_LENGTH_ERROR }
            field = value
        }

    init {
        this.name = name
    }
}