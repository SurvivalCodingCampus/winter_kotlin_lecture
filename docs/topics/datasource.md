# DataSource(데이터 소스)

## 데이터 소스 
- 데이터의 근간이 되는 원천 재료 

## 데이터 소스 
- 프로그램이 사용하는 원천 데이터 모든 것이 해당 함
- (밭에서 나는 농작물)

## DataSource의 종류
- Text
- File
- JSON
- XML
- CSV
- RDBMS
- NoSQL
- 등등

## DataSource로 뭘하지?
- 도서관 책 관리 프로그램
  - 책 정보 제공
  - 온라인 도서 제공

- (비빔밥)
  - 당근
  - 양파

## 데이터 소스를 활용할 데이터로 변환하자
Datasource에서 추출한 가공되지 않은 데이터를 -> 사용 가능한 데이터로 변환

(당근)
(양파)

## 데이터 소스의 역할
1. 실제 CRUD 역할
2. 데이터 저장소와 직접 통신
3. Raw 데이터 처리 


## 간단한 메모장 앱 예시
```kotlin
interface MemoDataSource {
    fun saveMemo(text: String)
    fun getMemos(): List<String>
}
```


## 여러가지 저장소 구현
```kotlin
class LocalMemoDataSource : MemoDatasource {
  private val memo = mutableListOf<String>()

  override fun saveMemo(text: String) {
    memos.add(text)
  }

  override fun getMemo(): List<String> {
    return memos.toList()
  }
}


class RemoteMemoDataSource : MemoDataSource {
  override fun saveMemo(text: String) {
        // 서버에서 저장   
  }
  
  override fun getMemos(): List<String> {
       // 서버에서 조회
  }
}
```

## 데이터 소스 구현체 이름 규칙 예시
- 접두어로 저장소 유형 표시 
- 구현 기술이 명확할 경우 해당 이름 사용 

## Impl 접미사를 사용하는 이름 관례
- 구현체임을 명확히 표시
- 인터페이스와 구현체 구분 용이
- 많은 기업 / 프로젝트에서 채택하는 관례












