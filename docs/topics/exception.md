### 일일 학습 기록 (상세)
```markdown
# 2024-12-31

## 📚 오늘 배운 내용
- 예외 (Exception)

### 정리

#### - 에러
- syntax error, runtime error, logic error 의 3종류
- 예외처리를 할 때는, runtime error를 대체한다

#### - 예외의 종류
- API에는 여러가지 예외적 상황을 표현하는 예외 클래스가 준비되어 있다.
- 예외 클래스를 상속하여 오리지날 예외 클래스를 정의할 수 있다.

#### - 예외 처리
- try-catch 문을 사용하면, try 블록 내에서 예외가 발생했을 때 catch 블록에서 처리가 옮겨진다
- finally 블록으로 나중에 꼭 해야하는 처리를 할 수 있다
- throw 문을 사용하면 임의로 예외를 발생시킬 수 있다.


### 전체
#### - 예외 (Exception)
- 프로그램을 설계할 때
- 실행시에 예외 상황이 발생 할 가능성이 있는 것을 예측하여, 사전에 예외 처리가 되도록 할 필요가 있다.
- 이럴 때 적절한 조치가 없으면 프로그램은 에러가 나며 죽어 버린다.
- 예상 외의 상황에 적절한 조치를 취하는 것을 배운다.

#### - 에러의 종류와 대응책
1. 문법 에러 (syntax error)
2. 실행 시 에러 (runtime error)
3. 논리 에러 (logic error)

#### - 에러 상황 별 처리
- syntax error
- 원인           : 코드의 형식적 오류
- 알아 채는 방법  : 컴파일하면 에러 남
- 해결 방법       : 컴파일러의 지적을 보고 수정

- runtime error
- 원인           : 실행 중에 예상외의 사태가 발생하여 동작이 중지됨
- 알아 채는 방법  : 실행하면 도중에 강제 종료 됨
- 해결 방법       : 에러

- logic error
- 원인           : 기술적 처리 내용에 논리적인 오류가 있음
- 알아 채는 방법  : 실행하면 예상외의 값이 나옴
- 해결 방법       : 원인을 스스로 찾아서 해결해야 함

#### - 예외적인 상황들
- 메모리 부족
- 파일을 찾을 수 없음
- 네트워크 통신 불가 등

#### - 예외 처리의 흐름
- try {
    // 에러가 날 것으로 예상되는 코드 작성
  } catch (e: Exception) {
    // e : 에러의 정보를 담고 있는 객체
  }
- 예외를 발생
- throw Exception("에러 메세지") // 이렇게 하면 콘솔창에 에러 메세지 뜸

- try-catch 문으로 Exception 계열 예외를 처리
- try {
      someError()  // throw Exception("에러발생") 함수임
  } catch (e: Exception) {
      print(e.message)
  }
  
- rethrow 로 에러 처리를 미룸
- try {
        someError2()  // 위의 soneError()을 실행하고 catch로 throw e 함
  } catch (e: Exception) {
        print(e.message)
  }

- 특정 예외를 캐치
- try {
        someError2()  
  } catch (e: IllegalArgumentException) {
        print(e.message)
  } catch (e: NumberFormatException) {
        print(e.message)
  } catch (e: Exception) {
        e.printStackTrace()
  }
  
- finally 로 항상 해야하는 처리
- try {
        // 무언가
  } catch (e: IllegalArgumentException) {
        // 무언가
  } finally {
        // 항상 해야하는 처리
  }

- 오리지널 예외 클래스 정의
- Exception 클래스 상속 받아서 정의


## 💻 예제 코드
- [예외 수업](../../src/main/kotlin/day11/ExceptionExam.kt)
- [예외 연습문제](../../src/main/kotlin/day11/ExceptionPractice.kt)
- [파일 조작 연습문제](../../src/main/kotlin/day11/FileOperations.kt)
- [파일 조작 연습문제](../../src/main/kotlin/day11/DefaultFileOperations.kt)
- [파일 조작 연습문제](../../src/test/kotlin/day11/DefaultFileOperationsTest.kt)
- [여러가지 데이터 형식 연습문제](../../src/main/kotlin/day11/Employee.kt)
- [여러가지 데이터 형식 연습문제](../../src/main/kotlin/day11/Department.kt)
- [여러가지 데이터 형식 연습문제](../../src/test/kotlin/day11/SerializationPracticeKtTest.kt)


```