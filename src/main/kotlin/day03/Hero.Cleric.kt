package org.example.day03

const val MAX_HP = 50
const val MAX_MP = 10
const val USE_SELF_AID_MP = 5

class Cleric(
    override var name: String,
    override var hp: Int = 50,
    override var mp: Int = 10,
) : Hero(name, hp, mp) {
    val maxHp = MAX_HP
    val maxMp = MAX_MP

    fun usingMp(consuming: Int): Int {
        when {
            mp == 0 -> return 0
            mp > 0 -> {
                mp -= consuming
            }
        }
        return mp
    }

    fun getDamaged(damagedNum: Int) {
        when {
            hp != 0 && damagedNum > 0 -> hp -= damagedNum
            damagedNum > hp -> hp = 0
            damagedNum < 0 -> return
        }
    }

    fun showingStatus() {
        println("$name status : \n hp : $hp , mp : $mp")
    }

    fun selfAid() {
        when {
            hp > 0 && mp >= USE_SELF_AID_MP -> {
                hp = MAX_HP
                mp -= USE_SELF_AID_MP
            }
        }
    }

    fun pray(sec: Int): Int {

        val minRecoverMp: Int = 3
        var recoveredMp: Int = 0
        val count: Int = sec / minRecoverMp

        // mp가 100 이상일때 0
        if (mp >= MAX_MP) return 0

        // 초가 이미 MAX_MP보다 넘었을때
        if (sec * minRecoverMp > MAX_MP) {
            // 최대치 recoverdMp
            recoveredMp = MAX_MP - mp
            // 100으로 초기화
            mp = MAX_MP
        } else {
            repeat(count) { recoveredMp += (3..5).random() }

            mp += recoveredMp
        }
        return recoveredMp
    }
}

