### 람다식
- 람다식 : 함수 내용을 바로 정의해서 사용하고 싶을 때 사용 (주로 함수형 프로그래밍에서 사용된다)
  ```text
  람다식 형태
  
  { 입력 파라미터 -> 함수의 본문 }
  ```
  ```kotlin
  val list = listOf(3, 12, 7, 20, 9)
  val filteredList = list.filter { it > 10 }    // filter는 리스트를 순회
  println(filteredList) // [12, 20]
  ```
  ```kotlin
  val loudify = { msg: String -> "!!! ${msg.uppercase()} !!!"}  // 람다식을 변수로 저장. 
  assert(loudify("hello") == "!!! HELLO !!!")   //이 변수는 함수처럼 동작
  ```
- 함수형 프로그래밍은 가변데이터(외부요인) 멀리하는 특징을 가진다
- 메서드와 함수의 차이 : 메서드는 이름이 있지만 함수는 이름이 중요치 않다