package org.example.day03


class Wizard(
    override var name: String,
    override var hp: Int = 50,
    override var mp: Int = 10,
) : Hero(name, hp, mp) {

    fun heal(hero: Hero): Int {
//        val minRecoverMp: Int = 3
//        var recoveredMp: Int = 0
//        if (mp >= MAX_MP) return 0
//
        return 0
    }
}

