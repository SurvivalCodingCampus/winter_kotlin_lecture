### 컬렉션

### 데이터 구조에 따른 대표적인 컬렉션(자료구조)

1) List: 순서 대로 쌓여 있는 구조(아이템의 중복 허용)
2) Map: 키(key)나 값(value)의 쌍으로 저장(키의 중복 불가)
3) Set: 순서가 없는 집합(중복 불가)

### List

- listOf(): 수정 불가 리스트
- mutableListOf(): 수정 가능 리스트

Array도 있으나 가급적 List사용

# 컬렉션

### Set

> 중복 값을 허용하지 않는 집합
> getter는 제공하지 않기 때문에 반복이 필요하면 iterator()를 사용하거나 forEach()를 사용
> List의 contains 보다 압도적으로 빠름, 또한 요소를 탐색할수 있는 iterator 제공

### Map

키(key): 값(value)의 쌍으로 이루어진 요소를 담는 자료구조
키의 중복은 허용되지 않음

### 컬렉션 선택

- key,value쌍 : Map
- 중복 가능: List
- 중복 불기: Set
- 순서 중요: List
- 순서 안 중요: Set
- 검색 속도 중요: Set













