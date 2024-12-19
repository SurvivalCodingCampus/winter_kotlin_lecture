package org.example.day03

const val MAX_HP = 50
const val MAX_MP = 10
const val USE_MP_SELF_AID = 5

class Cleric(
    override var name: String,
    override var hp: Int = 50,
    override var mp: Int = 10,
) : Hero(name, hp, mp) {
    private val maxHp : Int = MAX_HP
    private val maxMp : Int = MAX_MP
    private val useMpSelfAid : Int = USE_MP_SELF_AID

    fun usingMp(consuming: Int): Int {
        when {
            mp == 0 -> return 0
            mp > 0 -> {
                mp -= consuming
            }
        }
        return mp
    }

    fun takenDamage(damageScore: Int) {
        when {
            hp != 0 && damageScore > 0 -> hp -= damageScore
            damageScore > hp -> hp = 0
            damageScore < 0 -> return
        }
    }

    fun showingStatus() {
        println("$name status : \n hp : $hp , mp : $mp")
    }

    fun selfAid() {
        when {
            hp > 0 && mp >= useMpSelfAid -> {
                hp = maxHp
                mp -= useMpSelfAid 
            }
        }
    }

    fun pray(totalSeconds: Int): Int {

        val minRecoverPerInterval = 3
        val maxRecoverPerInterval = 5
        val intervalSeconds =  3
        val count: Int = totalSeconds / intervalSeconds

        if (mp >= maxMp) return 0

        val potentialRecovery : Int = if (totalSeconds * intervalSeconds > maxMp) {
            maxMp - mp
        } else {
            var recovery = 0
            repeat(count) { recovery += (minRecoverPerInterval..maxRecoverPerInterval).random() }
            recovery
        }
        mp = (mp + potentialRecovery).coerceAtMost(maxMp)
        return potentialRecovery
    }
}

