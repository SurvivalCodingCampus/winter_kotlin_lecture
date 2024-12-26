package day5

import day3.Hero
import day6.Actor
import day6.HealthPoint
import kotlin.properties.Delegates

open class Wizard(
    name: String,
    hp: Int = 100,
    mp: Double = 100.0,
    wand: Wand? = null,
) : Actor(name, HealthPoint(hp)) {
    private lateinit var _name: String
    private var _mp by Delegates.notNull<Double>()
    private var _wand: Wand? = null

    final override var name: String
        set(value) {
            require(value.length >= 3) { "이름의 최소길이는 3문자입니다." }
            _name = value
        }
        get() = _name

    var mp: Double
        set(value) {
            require(value > 0) { "마법사의 MP는 0 이상이어야 함." }
            _mp = value
        }
        get() = _mp

    var wand: Wand?
        set(value) {
            requireNotNull(value)
            _wand = value
        }
        get() = _wand

    init {
        this._wand = wand // initial state can be null
        this.name = name
        this.mp = mp
    }

    fun heal(hero: Hero) {
        if (mp < 10) {
            println("마나가 부족합니다.")
            return
        }

        hero.hp += 20
        this.mp -= 10
        println("힐을 시전했습니다. 대상 HP상태: ${hero.hp.percent}%")
    }
}