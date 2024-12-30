package com.survivalcoding.com.survivalcoding.day08

data class Team(val name: String, val members: MutableList<String>)

fun main() {

    val team1 = Team("AE!", mutableListOf("Kim"))
    val team2 = team1.copy()
    team2.members.add("Lee")
    println(team1.members.size)
}
