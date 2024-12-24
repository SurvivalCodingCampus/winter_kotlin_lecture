package org.example.domain.traits

interface GetDamageable {
    var hp: Int
    fun getDamage(damage: Int)
    fun getDamageMessage(damage: Int): String = "$damage 포인트의 데미지"
}