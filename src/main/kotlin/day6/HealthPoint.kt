package day6

import kotlin.math.absoluteValue
import kotlin.math.floor

class HealthPoint(value: Int, var maximum: Int = value) {
    var value: Int = value
        set(value) {
            val newValue = value.coerceIn(0..maximum)

            val diff = this.value - newValue
            when {
                diff > 0 -> println("${diff.absoluteValue}포인트 데미지")
                diff < 0 -> println("${diff.absoluteValue}포인트 회복")
                else -> {}
            }
            field = newValue
        }

    var percent: Float
        get() = (100 * value / maximum).toFloat()
        set(value) {
            val newValue = floor(value / 100F * maximum).toInt()
            this.value = newValue
        }
}
