package org.example.day03

open class Hero(
    open val name: String,
    open var hp: Int = MAX_HP,
    var sword: Sword? = null,
) {


    companion object {
        const val MONEY= 1000
    }


    fun attack() {}
    fun run() {}
    fun sleep() {}
    fun usingSkills() {
    }
}

class Sword(
    val name: String,
    val damage: Int,
){

}