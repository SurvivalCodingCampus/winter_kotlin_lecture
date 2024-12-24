package day3

import day6.Actor
import day6.HealthPoint

open class Slime(
    suffix: String,
    hp: Int = 50,
) : Actor(name = "Slime $suffix", HealthPoint(hp)) {

    companion object {
        const val DEFAULT_BASIC_DAMAGE = 5
    }

    var target: Actor? = null
    open fun attack() {
        target?.let { basicAttack(it) }
    }

    private fun basicAttack(target: Actor) {
        target.hp.value -= DEFAULT_BASIC_DAMAGE
        println("Basic attack to ${target.name}")
    }

}