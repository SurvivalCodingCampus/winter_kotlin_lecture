package org.example.day07

class Dancer(
    name: String,
    hp: Int,
) : Character(name, hp) {
    override fun attack(character: Character) {
        println("${name}이 ${character.name}을 공격")
    }
}