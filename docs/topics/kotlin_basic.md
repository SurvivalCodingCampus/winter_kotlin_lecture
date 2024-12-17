# Kotlin basics

## Negative _in_ syntax
```kotlin
val list = listOf("a", "b", "c")

if (-1 !in 0..list.lastIndex) {
    println("-1 is out of range")
}
if (list.size !in list.indices) {
    println("list size is out of valid list indices range, too")
}
```

## Various range supplements syntax
```kotlin
for (x in 1..10 step 2) {
    print(x)
}
println()
for (x in 9 downTo 0 step 3) {
    print(x)
}
```
- step: 2단계씩 이동한다.
- downTo: 거꾸로 다음에 붙는 요소까지 뱉어낸다.

### iterator를 거꾸로 진행시킬때는 어떻게 해야할까

```kotlin
val listOfElements = listOf(1,5,2,5,7,8,3)
for (el in myRange.reversed()) {
    //code
}
```
List.reversed() cpp의 rbegin()같은 뒤집힌 이터레이터를 얻을수 있다.