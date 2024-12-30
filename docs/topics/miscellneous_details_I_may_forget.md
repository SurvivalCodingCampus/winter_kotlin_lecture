# MDIMF

## Kotlin related

- smart casting doesn't work for members, they might be null in race-conditions
    - wrap nullable member with ?.let block
    - Syncronized won't work because they just ensure mutual exclusion amoung syncronized
- sealed classes must be in same package or module
- data class copy() is a shallow copy operation
- data class Destructing declaration could be used like how typescript does
