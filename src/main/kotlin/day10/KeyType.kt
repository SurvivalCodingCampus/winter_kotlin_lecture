package day10

enum class KeyType(val lifespan: Int) {
    PADLOCK(1024), BUTTON(10_000), DIAL(30_000), FINGER(1_000_000)
}