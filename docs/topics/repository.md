# Model Class, Repository

## Model Class의 책임과 역할

- 모델 객체 클래스의 속성에 대한 데이터를 조회할 수 있는 클래스
- 별도의 기능을 가지지 않는 순수한 클래스
- 데이터 소스를 앱에 필요한 형태로 변환하여 앱 개발을 편리하게 해주는 역할 


## Model Class
```kotlin
data class User(
    val name: String,
    val email: String,
)
```

- View에 보여질 데이터를 담는 객체
    - View == 눈에 보이는 부분

- 비슷한 용어들
    - 도메인 모델
    - Entity
    - DTO
    - POJO
    - VO
    - 데이터 클래스(4종 세트)
      hashCode(),toString(), copy(), equals()

## 모델링 방법
- DDD
- ORM

## DDD(Domain Driven Design)
- Domain의 정의
    - 유사한 업무의 집합
    - 특정 상황(주문, 결재, 로그인)이나 특정 객체(유저, 손님)가 중심이 될 수 있음
- 모델 클래스
    - 도메인을 data 클래스로 작성한 것 


## DDD(Domain Driven Design)
- Domain의 정의
    - 유사한 업무의 집합
    - 특정 상황(주문, 결재, 로그인)이나 특정 객체(유저, 손님)가 중심이 될 수 있음 

- 모델 클래스
    - 도메인을 data 클래스로 작성한 것

## ORM
- 데이터 소스가 DB인 경우 DB와 모델간 상호 변환을 도와주는 기법 
- ORM은 DB를 활용할 경우에 따로 살펴봐도 됨


## 정리
- 모델 클래스를 정의하는 방법은 여러가지
- 일반적으로 data class로 정의 


## Repository 패턴
- Repository 패턴은 소프트 웨어 개발에서 데이터 저장소에 접근하는 객체를 추상화
- 데이터소스(DB, File 등)와의 통신을 담당하는 객체를 캡슐화하는 디자인 패턴 

## Repository의 책임과 역할
- 데이터 접근에 대한 추상화 계층
- 데이터 소스 은닉
- 도메인 객체와 데이터 소스 사이의 중재자
- 데이터 매핑, 변환 담당


## Repository 패턴의 이점
- 데이터 접근 추상화
  - 데이터 소스 구현 세부사항 은닉
  - 일관된 인터페이스 제공

- 유지보수성 향상
    - 관심사 분리
    - 코드 재사용성

- 테스트 용이성 
    - 데이터 소스 Mocking 가능
    - 단위 테스트 작성 용이

- 확장성
    - 새로운 데이터 소스 추가 용이
    - 기존 코드 수정 최소화
    - 인터페이스 기반 설계

## 데이터 소스는 기본 CRUD를 제공
```kotlin
interface UserDataSource {
    fun getUser(id: String): User?
    fun saveUser(user: User)
    fun getAllUser(): List<User>
}
```

## 데이터 소스 구현
```kotlin
class FileUserDataSource : UserDataSource {
    private val filePath = "users.txt"

    override fun getUser(id: String): User? {
        // ...파일에서 정보를 읽어오는 구현
    }

    override fun saveUser(user: User) {
        // ... 파일에 사용자 정보를 저장하는 구현
    }

    override fun getAllUsers(): List<User> {
        // ... 모든 사용자 정보를 읽어오는 구현 
    }
}

용도에 맞게 구현
- File 조작
- 서버와 통신
- 메모리를 사용 
```
## Repository에서 도메인 특화 기능을 제공
- 도메인
  - 비즈니스 문제 영역


## 도메인 특화 기능을 Repository가 제공하는 경우의 장점
- 도메인 의도가 명확히 드러남
- 재사용 가능한 쿼리 로직
- 데이터 소스 구현과 분리된 비즈니스 요구사항 정리 

## 주의할 점 
- Repository는 단순 데이터 조작만 해야 함
- 복잡한 비즈니스 로직은 더 상위 계층으로
- 성능을 고려한 쿼리 설계 필요 

## Repository 적용한 예시 
```kotlin
fun main() {
    val repository = UserRepository(FileUserDataSource)

    // 이름 역순으로 사용자 조회
    val sortedUsers = repository.findUsersOrderByNameDescending()
    println(
        "Users sorted by name: ${
            sortedUsers.map { it.name }")
        }
```
## 정리
- DataSource는 데이터 접근 방법 정의
- Model 객체는 데이터 구조 정의(순수 데이터만)
- Repository는 DataSource 사용 및 관리
- 단순하고 명확한 구조 유지












