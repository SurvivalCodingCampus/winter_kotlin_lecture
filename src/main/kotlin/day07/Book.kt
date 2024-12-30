package org.example.day07

class Book(
    name: String,
    price: Int,
    color: String,
    val isbn: String,
    weight: Double,
): TangibleAsset(name, price, color, weight) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false
        if (!super.equals(other)) return false

        other as Book

        return isbn == other.isbn
    }

    override fun hashCode(): Int {
        var result = super.hashCode()
        result = 31 * result + isbn.hashCode()
        return result
    }

}