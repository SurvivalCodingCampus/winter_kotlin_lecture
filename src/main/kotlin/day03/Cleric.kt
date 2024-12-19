package org.example.day03

import org.example.day4.skills.Prayable
import org.example.day4.skills.SelfAidable

class Cleric(
    var name: String,
    var hp: Int = MAX_HP,
    var mp: Int = MAX_MP,
): Prayable, SelfAidable {
    companion object {
        const val MAX_HP = 50
        const val MAX_MP = 10
    }

    override fun selfAid() {
        if (mp < SelfAidable.NEED_MP) {
            return
        }
        mp -= SelfAidable.NEED_MP
        hp = MAX_HP
    }

    override fun pray(prayTime: Int): Int {
        if (prayTime < 1) {
            return 0
        }
        var recover = prayTime + (0..Prayable.RANDOM_COLLECTION_MP_RANGE).random()
        mp += recover
        if (mp > MAX_MP) {
            recover = 0
            mp = MAX_MP
        }
        return recover
    }
}


