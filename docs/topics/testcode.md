# Kotlin 01-2 Test 코드 작성 방법

## 📚 오늘 배운 내용

### Test 코드 작성 순서
1. 테스트 하고 싶은 파일을 고른다.

2. 클래스 생성자 부분 클릭후 전구 모양 클릭! -> Create test를 누르고 Junit4 선택 후 테스트할 메서드 선택

3. Test 코드 작성
> 여러가지 테스트 기법 중 given > when > then 기법을 사용 한다. 
> assert*() 함수를 활용한 결과 검증
```kotlin
class ClericTest {

    @Test
    fun selfAid() {
        // given(준비)
        val cleric = Cleric(hp = 50, mp = 10)

        // when(실행)
        cleric.selfAid()

        // then(검증)
        assertEquals(cleric.maxMp - 5, cleric.mp)
        assertEquals(cleric.maxHp, cleric.hp)
    }
}
```