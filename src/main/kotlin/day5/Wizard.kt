package day5

import day6.Actor
import kotlin.properties.Delegates

class Wizard(
    name: String,
    HP: Int = 100,
    MP: Double = 10.0,
    wand: Wand? = null,
) : Actor(name) {
    private lateinit var _name: String
    private var _mp by Delegates.notNull<Double>()
    private var _hp by Delegates.notNull<Int>()
    private var _wand: Wand? = null

    override var name: String
        set(value) {
            require(value.length >= 3) { "이름의 최소길이는 3문자입니다." }
            _name = value
        }
        get() = _name

    var HP: Int
        set(value) {
            _hp = value.coerceAtLeast(0)
        }
        get() = _hp

    var MP: Double
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
        this.HP = HP
        this.MP = MP
    }
}