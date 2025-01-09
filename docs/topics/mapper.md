# DTO, Mapper

## 데이터소스를 모델로 변경하기 어려운 경우
- 동적 JSON
- 서버에서 아예 잘못된 값을 보내는 경우 


### DTO(Data Transfer Object)
데이터 소스를 모델 클래스로 변환하는 과정에서
순수하게 클래스에 담기 위한 중간 전달 객체


Json -------------> Dto ----------------> Model Class

-> 잘못된 데이터 소스를 받더라도 안 터지게 하려는 클라이언트 개발자의 방어 수단 

### DTO 코드 예시
- 모든 클래스와 비교하여 어떤 특징이 있는가?
-> 모든 필드가 Nullable

즉, Json을 무지성으로 받아들인다.
불안한 JSON을 받기 위해 기존 모델 클래스를 Dto가 대체 

### DataSource의 반환 객체 변경
- 이제 DataSource는 모델 말고 Dto 객체를 반환

### Dto를 모델 클래스로 변환
- 순수한 데이터 소스(DTO)를 원하는 모델 클래스로 변환하려면 변환 기능을 제공할 mapper 함수 필요 

Json --------------> DTO --------------------------------> Model Class

mapper: DTO -> Model

### DTO를 모델로 변경했을때의 장점
- Boolean 필드는 is 접두어 사용(코틀린 컨벤션)
- Nullable 타입(?) 제거로 안정성 향상
- 도메인 모델은 순수 코틀리 타입 사용


### DTO를 모델로 변경했을때의 장점
```kotlin
// TodoMapper.kt
fun TodoDto.toTodo(): Todo {
    return Todo(
        userId = userId ?: 0,
        id = id ?: 0,
        title 
    )
}

맵퍼는 Dto를 모델 클래스로 변환하는 유틸 메소드

Nullable을 non - Nullable로 변환하는 것이 핵심

DTO 전체를 변환하는 것이 아니다. 필요한 부분만 변환
```

### DTO가 필요한 이유
- Model Class는 non-nullable 한 값만 가지고 있도록 함
- Json 데이터는 null 값을 포함할 수 있음
- Map -> Model Class 변환시 null 값 등의 예외를 사전에 걸러내기 용이
- 불완전한 코드가 포함될 것 같다면 Dto를 도입 하자
- Json 예외가 없다면 반드시 Dto를 도입할 필요 x


### 정리
기존에 작성한 모델 클래스는 DTO와 모델 클래스의 역할을 모두 가지는 클래스

DTO가 도입된다면 역할 분담 가능
- DTO: 데이터 소스 직렬화, 역직렬화
- 모델 클래스: DTO에서 필요한 내용만 활용하는 도메인 객체









