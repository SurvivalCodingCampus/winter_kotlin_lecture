package org.example.day06

open class Hero(
    name: String,
    hp: Int = DEFAULT_MAX_HP,
    mp: Int = DEFAULT_MAX_MP,
    var weapon: Weapon? = null
) {
    var name: String = name
        set(value) {
            require(value.length >= 3) { ERROR_MSG_NAME_LENGTH }
            field = value
        }

    var maxHp: Int = hp
        private set(value) {
            field = if (value < 0) 0 else value
        }

    var maxMp: Int = mp
        private set(value) {
            field = if (value < 0) 0 else value
        }

    var hp: Int = hp
        private set(value) {
            field = when {
                value > maxHp -> {
                    maxHp
                }

                value < 0 -> {
                    0
                }

                else -> {
                    value
                }
            }
        }

    var mp: Int = mp
        private set(value) {
            field = when {
                value > maxMp -> {
                    maxMp
                }

                value < 0 -> {
                    0
                }

                else -> {
                    value
                }
            }
        }

    init {
        this.name = name
        this.maxHp = maxHp
        this.maxMp = maxMp
        this.hp = hp
        this.mp = mp
    }

    open fun reduceHp(damage: Int) {
        require(damage >= 0) { ERROR_MSG_NEGATIVE_DAMAGE }
        hp -= damage
    }

    open fun reduceMp(cost: Int) {
        require(cost >= 0) { ERROR_MSG_NEGATIVE_MANA_COST }
        mp -= cost
    }

    open fun recoverHp(heal: Int) {
        require(heal >= 0) { ERROR_MSG_NEGATIVE_HEAL }
        hp += heal
    }

    open fun recoverMp(heal: Int) {
        require(heal >= 0) { ERROR_MSG_NEGATIVE_HEAL }
        mp += heal
    }

    open fun attack() {

    }

    companion object {
        const val DEFAULT_MAX_HP = 50
        const val DEFAULT_MAX_MP = 50
        const val ERROR_MSG_NAME_LENGTH = "이름은 3글자 이상이어야 합니다."
        const val ERROR_MSG_NEGATIVE_DAMAGE = "데미지는 0 이상이어야 합니다."
        const val ERROR_MSG_NEGATIVE_MANA_COST = "마나 사용량은 0 이상이어야 합니다."
        const val ERROR_MSG_NEGATIVE_HEAL = "회복량은 0 이상이어야 합니다"
    }
}