## 문자열 조작

### 문자열 처리(결합)
```text
"Hello" + "Dart"

=> "Hello Dart"
```

### string interpolation
```text
${수식}을 활용한 문자열 결합 
```


### 문자열 결합 방법
- +연산
- String interpolation
- StringBuilder
- StringBuffer


### StringBuffer
- append() 메서드로 결합한 결과를 내부 메모리(버퍼)에 담아두고 toString()으로 결과 얻음 

### +연산자가 느린 이유
- String 인스턴스는 불변 객체(immutable)


