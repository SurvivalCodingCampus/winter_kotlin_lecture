# TDD (Test-Driven Development)

## TDD 단계

1. **테스트 작성**
    - 요구사항에 맞는 테스트를 작성
    - 아직 구현되지 않은 코드이므로 **테스트 당연히 실패**..😔

2. **코드 작성**
    - 테스트를 통과하기 위한 **최소한의 코드**를 작성

3. **리팩터링**
    - 코드를 개선하거나 정리하면서 테스트를 유지

---

## `StrongBox`클래스를 TDD로 구현하는 과정

**테스트를 작성**하고, 테스트를 통과하는 **최소한의 코드를 작성**하는 과정을 반복

### 1단계: 테스트 작성

```kotlin
class StrongBoxTest {

    private lateinit var padlockBox: StrongBox<String>
    private lateinit var buttonBox: StrongBox<Int>
    private lateinit var dialBox: StrongBox<String>
    private lateinit var fingerBox: StrongBox<Double>

    @Before
    fun setUp() {
        padlockBox = StrongBox(KeyType.PADLOCK)
        buttonBox = StrongBox(KeyType.BUTTON)
        dialBox = StrongBox(KeyType.DIAL)
        fingerBox = StrongBox(KeyType.FINGER)
    }

    @Test
    fun `초기 호출은 null 리턴`() {
        padlockBox.put("Treasure")
        assertNull(padlockBox.get())
    }

    @Test
    fun `10_000회까지 null 리턴 10_001회 도달하면 값 리턴 `() {
        buttonBox.put(42)
        repeat(10_000) { assertNull(buttonBox.get()) }
        assertEquals(42, buttonBox.get())
    }
}
```

### 2단계: 최소한의 코드 작성

```kotlin
enum class KeyType(val maxAttempts: Long) {
    PADLOCK(1_024),
    BUTTON(10_000),
    DIAL(30_000),
    FINGER(1_000_000)
}

class StrongBox<T>(private val keyType: KeyType) {
    private var item: T? = null
    private var usageCount: Long = 0

    fun put(item: T) {
        this.item = item
    }

    fun get(): T? {
        if (usageCount >= keyType.maxAttempts) {
            return item
        }
        usageCount++
        return null
    }
}
```

### 3단계: 테스트 코드 실행

코드 구현 후 테스트를 실행해서 통과하는지 확인

![image](https://github.com/user-attachments/assets/7e1c6c53-e29b-41ba-9e44-e05a1b63df32)

### 4단계: 리팩터링

코드를 개선하거나 Edge Case를 추가로 처리

```kotlin
 @Test
fun `아무것도 넣지 않은 금고`() {
    val emptyBox = StrongBox<String>(KeyType.DIAL)
    assertNull(emptyBox.get())
    repeat(30_000) { assertNull(emptyBox.get()) }
    assertNull(emptyBox.get())
}

@Test
fun `금고에는 1개의 인스턴스만 담을 수 있다`() {
    padlockBox.put("Treasure")
    padlockBox.put("Diamond")
    repeat(1_024) { assertNull(padlockBox.get()) }
    assertEquals("Diamond", padlockBox.get())
}
```