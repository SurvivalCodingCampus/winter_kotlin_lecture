package day10

class StrongBox<T>(val keyType: KeyType) {
    private var content: T? = null
    private var count: Int = 0

    fun get(): T? {
        if(count < keyType.count) {
            count++
            return null
        }

        return this.content
    }
    fun put(content: T) {
        this.content = content
    }

    enum class KeyType(val count: Int) {
        PADLOCK(1024),
        BUTTON(10000),
        DIAL(30000),
        FINGER(1000000)
    }
}