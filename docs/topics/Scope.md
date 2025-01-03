
### 스코프함수
- 스코프함수 : 특정 객체에 대해 코드 블록을 실행할 수 있도록 도와주는 함수들
    - apply
        - 객체 자체를 반환하고, 객체의 속성에 값을 설정하는 데 사용된다.
        - this로 객체를 참조한다.
      ```kotlin
      val person = Person().apply {
      name = "John"
      age = 30
      }
      ```
    - with
        - 객체를 람다 블록에 전달하고, 객체의 속성에 접근한다. this로 객체를 참조하며, 반환값을 사용하지 않는 경우에 적합하다.
        - 주로 여러 속성에 접근할 때 사용된다.
      ```kotlin
      val person = Person()
      with(person) {
      name = "Alice"
      age = 25
      }
      ```
    - let
        - 객체를 전달받아 람다 식 안에서 작업을 수행하고 결과를 반환한다.
        - 반환값을 사용할 때 주로 사용된다.
        - it을 기본으로 객체를 참조한다.
      ```kotlin
      val result = "Hello".let {
      it.toUpperCase()  // "HELLO"
      }
      ```
    - also
        - 객체를 람다 블록에 전달하고 객체 자체를 반환한다. 주로 객체에 부수적인 작업을 할 때 사용된다.
        - it을 기본으로 객체를 참조한다.
      ```kotlin
      val list = mutableListOf(1, 2, 3).also {
      println(it)  // [1, 2, 3]
      }
      ```
    - run
        - 객체를 참조하여 람다 블록을 실행하고, 결과를 반환한다.
        - 객체를 처리하는 후속 작업을 하고 값을 반환할 때 사용된다.
      ```kotlin
      val length = "Hello".run {
      length  // 5
      }
      ```
    - use
        - 자동 리소스 해제를 위해 사용하는 함수
        - 주로 입출력 스트림이나 데이터베이스 연결과 같은 자원을 사용할 때, 자원을 다 쓴 후 자동으로 해제하도록 도와주는 함수
        - 람다 블록을 실행하고 그 결과를 반환한다. 블록이 끝나면 close가 호출되어 자원이 해제된다.
      ```kotlin
      import java.io.File
      import java.io.BufferedReader
    
      fun readFile(fileName: String) {
      File(fileName).bufferedReader().use { reader ->
      val content = reader.readText()
      println(content)  // 파일 내용 출력
      }
      // reader.close()가 자동으로 호출 -> 명시적으로 close()를 호출할 필요가 없다
      }
      ```
      ```kotlin
      import java.sql.Connection
      import java.sql.DriverManager
  
      fun connectToDatabase(url: String, user: String, password: String) {
      DriverManager.getConnection(url, user, password).use { connection ->
      val statement = connection.createStatement()
      val resultSet = statement.executeQuery("SELECT * FROM users")
      while (resultSet.next()) {
      println(resultSet.getString("name"))
      }
      }
      // connection.close()는 자동으로 호출
      }
      ```