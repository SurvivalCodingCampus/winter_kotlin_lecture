# 파일 조작

## 📚 오늘 배운 내용

## 파일 조작의 기본 순서
1. 파일을 연다
2. 파일을 읽거나 쓴다
3. 파일을 닫는다

## File 쓰기 
```kotlin
// 파일 지정
val file = File("save.txt")

// 내용 쓰기
file.writeText("Hello, world!")
```

## File 읽기
```kotlin
val file = File("save.txt")

val text = file.readText()
println(text)
```

