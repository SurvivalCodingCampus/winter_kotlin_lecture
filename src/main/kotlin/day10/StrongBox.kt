package day10

class StrongBox<T>(private val keyType: KeyType) {
    private var content: T? = null
    private var lifespan = keyType.lifespan
    fun get(): T? = if (--lifespan > 0) null else content
    fun put(thing: T) {
        content = thing
    }
}