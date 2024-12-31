package org.example.day10


enum class KeyPad {
    PAD_LOCK, BUTTON, DIAL, FINGER
}


class LimitOfPad {
    companion object {
        const val PAD_LOCK = 1024
        const val BUTTON = 10000
        const val DIAL = 30000
        const val FINGER = 1000000
    }
}

enum class Hello {
    WORLD, SEOUL, BUSAN, HEHE
}


class StrongBox<T>(keyType: T) {
    private var _counter: Int = 0
    private var _keyPadType: T? = keyType


    fun put(keyPad: T?) {
        _keyPadType = keyPad
    }

    fun get(): T? {
        _counter += 1

        if (_counter >= checkingLimit(_keyPadType)) {
            println("${_keyPadType}이 해제되었습니다.${_counter}")
        } else {
            return null
        }

        return _keyPadType
    }


    private fun checkingLimit(keyType: T?): Int {
        return when (keyType) {
            KeyPad.PAD_LOCK -> LimitOfPad.PAD_LOCK
            KeyPad.BUTTON -> LimitOfPad.BUTTON
            KeyPad.DIAL -> LimitOfPad.DIAL
            KeyPad.FINGER -> LimitOfPad.FINGER
            else -> {
                0
            }
        }
    }


}


fun main() {

    val instance2 = StrongBox(KeyPad.DIAL)


    repeat(30001) {
        instance2.get()
    }

}