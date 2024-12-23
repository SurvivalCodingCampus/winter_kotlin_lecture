package day5

data class Entity(val name: String)

fun main() {
    val entities = listOf(Entity("홍길동"), Entity("한석봉"))
    entities.forEach { println(it.name) }

    val entityMap = entities.zip(arrayOf(20, 25))
    entityMap.forEach { println("${it.first.name}의 나이는 ${it.second}살") }
}

/**
 * 다음 정보를 저장하기 좋은 컬렉션을 List, Set, Map 중 고르시오
 *
 * 대한민국의 도시 이름 모음 (순서 상관 없음): Set
 * 10명 학생의 시험 점수: List
 * 대한민국의 도시별 인구수 (순서 상관 없음): Map
 */