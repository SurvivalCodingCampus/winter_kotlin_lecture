package org.example.day10

class StrongBox<E> {
    private var _item: E? = null

    fun put(item: E) {
        _item = item
    }

    fun get(): E? = _item
}