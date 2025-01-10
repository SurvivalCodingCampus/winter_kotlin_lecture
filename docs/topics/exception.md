# 예외

## 📚 오늘 배운 내용

## 예외
- 프로그램을 설계할 때 
- 실행시에 예외 상황이 발생 할 가능성이 있는 것을 예측하여, 사전에 예외 처리가 되도록 할 필요가 있음
- 이럴 때 적절한 조치가 없으면 프로그램을 에러가 나며 죽어 버림
- 예상 외의 상황에 적절한 조치를 취하는 것을 배운다. 

## 에러의 종류와 대응책
- 문법 에러
- 실행시 에러
- 논리 에러

## 에러 상황별 처리
- syntax Error
원인: 코드의 형식적 오류
알아채는 방법: 컴파일하면 에러 남
해결 방법: 컴파일러의 지적을 보고 수정

- runtime Error
원인: 실행 중에 예상외의 사태가 발생하여 동작이 중지됨
알아채는 방법: 실행하면 도중에 강제 종료 됨
해결방법: 에러

- logic Error
원인: 기술한 처리 내용에 논리적인 오류가 있음 
알아채는 방법: 실행하면 예상외의 값이 나옴
해결 방법: 원인을 스스로 찾아서 해결해야 함 

## 예외적인 상황들
- 메모리 부족
- 파일을 찾을 수 없음
- 네트워크 통신 불가

## 정리
에러
- syntax error, runtime error, logic error의 3종류
- 예외처리를 할 때는, runtime error를 대처한다.

예외의 종류
- API에는 여러가지 예외적 상황을 표현하는 예외 클래스가 준비되어 있다.
- 예외 클래스를 상속하여 오리지날 예외 클래스를 정의할 수 있다.

예외 처리
-  try-catch 문을 사용하면, try 블록 내에 예외가 발생했을때 catch 블록에서 처리가 옮겨진다. 
-  finally 블록으로 나중에 꼭 해야하는 처리를 할 수 있다.
-  throw 문을 사용하면 임의로 예외를 발생시킬 수 있다. 


## Result 패턴 

### 서버에 데이터 요청 시 예상되는 상황
- 성공 (Success)
- 실패 (Error, Failure)
  - 네트워크 연결이 아예 안 되어 있음
  - 네트워크 불안정으로 타임아웃 발생


### 에러처리의 기본 try - catch
```text
기본적으로 예외는 try - catch를 활용하여 처리한다.
런타임 에러 뿐만 아니라 논리적인 오류나 예외 상황에 대한 처리를 하기에는 부족하다.
Result 패턴은 성공, 실패시 처리에 유용한 패턴이다.
```


### Kotlin 제공 Result 클래스
```kotlin
fun fetchData(): Result<String> = kotlin.runCatching { 
    // 에러가 발생할 수 있는 코드
    if(someCondition) throw Exception("Error")
    "Success"
}

성공시 Result.success()
실패시 Result.failure()로 생성된 Result 타입을 반환
```

### 커스텀 실패 타입 정의
- sealed class : 제한된 상속을 가능하게 하는 클래스
- 쉽게 말하면 "가능한 모든 자식 클래스를 미리 정의"
- enum class 상위 호환

### 커스텀 Result 클래스 예시
- 더 명확한 에러 타입 구분
- 예외 throw / catch 없이 값으로 처리
- IDE에서 타입 추론과 자동완성 지원
- 커스텀 기능 추가 가능

```kotlin
sealed class Result<D> {
    data class Success<D>(val data: D) : Result<D>()
    data class Error(val e: Throwable) : Result<Nothing>()
}

Unit: 값은 있지만 의미 없음
Nothing: 절대 반환되지 않음 
```

### Result 패턴을 도입하는 곳에서 응답 객체를 Result 클래스로 랩핑하기 
```kotlin
suspend fun getTodo(id: Int): Result<Todo> {
    return try {
        Result.success(data = dataSource.getTodo(id).toTodo())
    } catch (e: Exception) {
        Result.Error(e)
    }
}
```

### Result 패턴 사용시 효과
- enum과 동일하게 when과 조합하여 모든 처리를 강제 할 수 있다.
- 여러가지 3개 이상의 성공과 실패를 처리할 수 있다. 

### 정리
- enum은 클래스만큼 자유롭지 않다. 
  - equals, hashCode 재정의가 불가능하다.
- sealed class는 서브타입을 봉인한다
- sealed class는 패턴매칭을 활용하여 모든 서브타입에 대한 처리를 하기 용이하다.
- Result 패턴은 여러가지 종류의 성공과 실패를 처리하기 용이한 패턴이다.
- 앱의 규모에 맞는 Result 패턴을 사용하자.




