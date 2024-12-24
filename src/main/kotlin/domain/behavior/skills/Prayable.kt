package org.example.day4.skills

interface Prayable {
    companion object {
        const val RANDOM_COLLECTION_MP_RANGE = 2
    }

    fun pray(prayTime: Int): Int
}