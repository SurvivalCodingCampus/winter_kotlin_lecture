# 여러가지 데이터 형식

## 📚 오늘 배운 내용

### CSV
- 데이터를 콤마로 나눈 형식
```kotlin
val str = "홍길동, 한석봉, 신사임당"
```

### 프로퍼티 형식의 파일 읽기
- Properties 클래스를 사용하여 키(key)와 값(value)의 쌍으로 읽고 쓰기가 가능
```text
data.properties 파일의 내용
heroName = 홍길동
heroHp = 100
```
### XML 형식
- <> 태그를 활용한 기술 방식
- 포함관계를 기술할 수 있음

```xml
<note>
    <to>Tove</to>
    <from>Jani</from>
    <heading>Reminder</heading>
    <body>Don't forget me this weekend!</body>
</note>
```
-> DOM Parser, SAX Parser 등을 통해 파서를 제작할 필요가 있음 

### JSON 형식
- 네트워크 통신에서 가장 많이 사용되고 있음
- XML에 비해 적은 용량
- []로 리스트, {}로 객체를 표현
- 키(key): 값(value) 형태

```json
{
  "이름": "홍길동",
  "나이": 25
}

```

### 원래 컴퓨터에서의 직렬화의 의미는
- 데이터 구조나 객체 상태를 저장하고 나중에 재구성할 수 있는 포맷으로 변환하는 과정
- 객체를 파일의 형태 등으로 저장하거나, 통신하기 쉬운 포맷으로 변환하는 과정을 의미
- 클래스 내부의 필드에 다른 클래스가 있다면 모두 직렬화 처리를 해줘야함 

### 직렬화(Serialization)
```text
모바일에서는 주로 서버와 Json으로 통신을 할 거기 때문에 Json 직렬화를 기본으로 한다. 

직렬화: 클래스 -> Json
역직렬화: Json -> 클래스 
```

```kotlin
import kotlinx.serialization.Serializable

@Serializable
data class User(
    val name: String,
    val email: String,
)


fun main() {
    // 직렬화 
    val json = Json.encodeToString(User("홍길동", "test@gmail.com"))
    println(json)
    
    // 역직렬화
    val obj = Json.decodeFromString<User>(json)
    println(obj)
}

```





