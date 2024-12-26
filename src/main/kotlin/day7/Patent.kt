package day7

import kotlinx.datetime.LocalDateTime

class Patent(
    name: String,
    validUntil: LocalDateTime,
    var uniqueIdentifier: String,
) : IntangibleAsset(name, validUntil) {
}