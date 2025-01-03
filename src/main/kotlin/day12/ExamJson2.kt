package day12

import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonArray
import kotlinx.serialization.json.decodeFromJsonElement

// json 형식의 데이터를 프로그램에서 처리하기 위해서는 Kotlin 객체로 변환해야 한다.

val jsonListString = """
    [
        {
            "id": 1,
            "name": "김철수",
            "email": "kim@example.com",
            "age": 30
        }
    ]
""".trimIndent()

// json 데이터와 일대일로 매핑되는 User 데이터 클래스. 이 클래스는 각 사용자의 정보를 담는 역할을 한다.
// @Serializable 어노테이션은 kotlinx.serialization 라이브러리에게 User 클래스를 직렬화할 수 있다는 것을 알려준다.
@Serializable
data class User(
    val id: Int,
    val name: String,
    val email: String,
    val age: Int
)

fun main() {
    // 방법1. json 문자열을 User 리스트로 변환
    val users = Json.decodeFromString<List<User>>(jsonListString)
    // 방법2. JsonArray로 변환한 후 map 함수를 사용하여 각 요소를 User 객체로 변환
    //val jsonList = Json.decodeFromString<JsonArray>(jsonListString)
    //val users = jsonList.map { json ->
    //    Json.decodeFromJsonElement<User>(json)
    //}


    // 변환된 users 리스트 사용
    users.forEach { user ->
        println("사용자 이름: ${user.name}, 이메일: ${user.email}")
    }
}

