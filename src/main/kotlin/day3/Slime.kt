package day3

import day6.Actor

open class Slime(
    var hp: Int,
    val suffix: String,
) : Actor(name = "Slime $suffix") {
}