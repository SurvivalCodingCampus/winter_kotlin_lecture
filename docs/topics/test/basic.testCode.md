# 1. JUnit 4

## 1) assertEquals
```kotlin
val exceptValue = 10

assertEquals(exceptValue, 10)
```

## 2) assertTrue
```kotlin
assertTrue("message", true)

assertTrue("Cleric Info : ${hero.name} \n recovered hp : $totalRecoveredMp  \n  0 < ${hero.mp} < $MAX_MP", hero.mp in 0 .. MAX_MP)
```
