### 일일 학습 기록 (상세)
```markdown
# 2024-12-18

## 📚 오늘 배운 내용
- 클래스에서 메소드가 정상적으로 작동하는지 테스트 코드 작성 필요
- 테스트 코드 생성 방법과 테스트 방법
- assert 사용법

## 💻 예제 코드
```kotlin
class ClericTest {

    @Before
    fun setUp() {
        // 테스트 실행 전에 수행되는 부분
    }
    
    @After
    fun tearDown() {
        // 테스트 실행 후에 수행되는 부분
    }
    
    @org.junit.Test
    fun selfAId() {
        val cleric = Cleric(name = "사제")
    
        for (i in 1..5) {
        cleric.selfAid()
        cleric.hp -= 100
        }
    
        assertEquals(100, cleric.hp)
    }
    
    @org.junit.Test
    fun pray() {
        val cleric = Cleric(name = "사제")
        
        assertTrue(cleric.pray() in 3..5)
    }
}

```