# DataSource

데이터의 근간이 되는 원천 재료

## DataSource의 종류

- Text
- File
- JSON
- XML
- CSV
- RDBMS
- NoSQL
- 등등

## DataSource로 뭘 하지?

- 도서관 책관리 프로그램
- 책 정보 제공
- 온라인 도서 목록
- 비빔밥
- 당근
- 양파
- DataSource에서 추출한 가공되지 않은 데이터를 → 사용 가능한 데이터로 변환

## DataSource의 역할

- 실제 CRUD 구현
- 데이터 저장소와 직접 통신
- Raw 데이터 처리

## 간단한 메모장 앱 예시

```kotlin
interface MemoDataSource {
    fun saveMemo(text: String)
    fun getMemos() : List<String>
}
```

```kotlin
class LocalMemoDataSource: MemoDataSource {
    private val memos = mutableListOf<String>()
    override fun saveMemo(text: String) {
        memos.add(text)
    }

    override fun getMemos(): List<String> {
        return memos.toList()
    }
}
```

```kotlin
class RemoteDataSource: MemoDataSource {
    override fun saveMemo(text: String) {
        // 서버에 저장
    }

    override fun getMemos(): List<String> {
        // 서버에서 조회
    }
}
```

## 정리

- DataSource는 데이터에 접근하는 계층을 분리하여 유연하고 테스트 가능한 아키텍처를 제공한다.
- 로컬 데이터 소스와 원격 데이터 소스를 나누어 각자의 역할을 명확히 할 수 있다.
- DataSource는 보통 앱의 비즈니스 로직과 UI를 분리하는데 중요한 역할을 하며, 데이터를 안전하고 효율적으로 관리할 수 있도록 돕는다.
