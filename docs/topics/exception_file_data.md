# 예외 & 파일조작 & 여러가지 데이터 형식

## 에러의 종류와 대응책

1. 문법 에러 (syntax error)
2. 실행 시 에러 (runtime error)
3. 논리 에러 (logic error)

|  | **syntax error** | **runtime error** | **logic error** |
| --- | --- | --- | --- |
| **원인** | 코드의 형식적 오류 | 실행 중에 예상외의 사태가 발생하여 동작이 중지됨 | 기술한 처리 내용에 논리적인 오류가 있음 |
| **알아 채는 방법** | 컴파일하면 에러 남 | 실행하면 도중에 강제 종료 됨 | 실행하면 예상외의 값이 나옴 |
| **해결 방법** | 컴파일러의 지적을 보고 수정 | 예외 처리 구현 | 원인을 스스로 찾아서 해결해야 함 |

## 예외적인 상황들

1. 메모리 부족
2. 파일을 찾을 수 없음
3. 네트워크 통신 불가 등

```kotlin
try {
		// 에러가 날 것으로 예상되는 코드 작성
} catch (e: Exception) {
		// e : 에러의 정보를 담고 있는 객체
}
```

## 예외처리

1. try-catch 문을 사용하면, try 블록 내에 예외가 발생했을 때 catch 블록에서 처리가 옮겨진다
2. finally 블록으로 나중에 꼭 해야하는 처리를 할 수 있다
3. throw 문을 사용하면 임의로 예외를 발생시킬 수 있다

# 파일 조작

## 파일 조작의 기본 순서

1. 파일을 연다
2. 파일을 읽거나 쓴다
3. 파일을 닫는다

```kotlin
val file = File("save.txt")
file.writeText("Hello World") // 쓰기
file.appendText("hi") // 이어 붙이기
file.readText() // 읽기 
file.delete() // 삭제 

```

# 여러가지 데이터 형식

## CSV

- 데이터를 콤마로 나눈 형식

```kotlin
val str = "홍길동, 한석봉, 신사임당"
```

## 프로퍼티 형식의 파일 읽기

- Properties 클래스를 사용하여 키(key)와 값(value)의 쌍으로 읽고 쓰기가 가능

```kotlin
//data.properties 파일의 내용
heroName = 홍길동
heroHp = 100
```

## XML 형식

- <> 태그를 활용한 기술 방식
- 포함관계를 기술할 수 있음
- Dom Parser, SAX Parser 등을 통해 파서를 제작할 필요가 있음

```kotlin
<note>
	<to>Tove</to>
	<from>Jani</from>
	<heading>Reminder</heading>
	<body>Don`t forget me this weekend!</body>
</note>

```

## Json 형식

- 네트워크 통신에서 가장 많이 사용되고 있음
- XML에 비해 적은 용량
- []로 리스트, {}로 객체를 표현
- 키(key): 값(value) 형태

```kotlin
{
	"이름": "홍길동",
	"나이": 25,
	"성별": "여",
	"주소": "서울특별시 양천구 목동",
	"특기": ["농구", "도술"],
}
```

## 직렬화(Serialization)

- 모바일에서는 주로 서버와 Json 으로 통신을 할 거기 때문에 Json 직렬화를 기본으로 한다
- 직렬화: 클래스 → Json
- 역직렬화: Json → 클래스

```kotlin
//코틀린에서 제공하는 라이브러리 
plugins {
    kotlin("plugin.serialization") version "2.1.0"
}

dependencies {
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.7.3")
}
```
