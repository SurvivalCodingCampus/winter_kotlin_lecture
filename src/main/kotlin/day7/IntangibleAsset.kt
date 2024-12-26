package day7

import kotlinx.datetime.LocalDateTime

abstract class IntangibleAsset(
    name: String,
    val validUntil: LocalDateTime,
) : Asset(name) {
}