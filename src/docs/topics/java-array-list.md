# java-array-list

## Java에서 ArrayList를 초기화 하는 방법

### 1. 초기화 후 요소 추가

```java
import java.util.ArrayList;
import java.util.List;

public static void main(String[] args) {
    List<String> items = new ArrayList<>();
    items.add("apple");
    items.add("banana");
}
```

### 2. Arrays.asList()

```java
import java.util.Arrays;

public static void main(String[] args) {
    List<String> items = Arrays.asList("apple", "banana");
}
```

### 3. List.of()

```java
import java.util.List;

public static void main(String[] args) {
    List<String> items = List.of("apple", "banana");
}
```

### 4. Stream으로 ArrayList 초기화

```java
import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public static void main(String[] args) {
    String[] arr = new String[]{"apple", "banana"};
    List<String> list = Stream.of(arr).collect(Collectors.toCollection(ArrayList::new));
}
```