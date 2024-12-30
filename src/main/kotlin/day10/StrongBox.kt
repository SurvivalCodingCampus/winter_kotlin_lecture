package org.example.day10


class StrongBox<E>(private val key: KeyType) {
    private var _item: E? = null
    private var _trialCount: Int = 0

    fun put(item: E) {
        _item = item
    }

    fun get(): E? {
        if (_trialCount < key.trialLimit) {
            _trialCount++
            return null
        }
        return _item
    }
}