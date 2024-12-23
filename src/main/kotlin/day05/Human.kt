package day05


/*
* 연습문제 1
* 다음 정보를 저장하기 좋은 컬렉션을 List, Set, Map 중 고르시오
* 1) 대한민국 도시 이름 모음(순서 상관 없음): 답: Set 이유) 보통 도시의 이름은 고유 해야하기 때문에 Set으로 결정했다. 하지만, 지역을 예로 든다면 이름이 같은 경우도 여러개 있기 때문에(ex) 인천 송도 vs 부산 송도) 이는 중복이 있다고 가정한다면 List도 맞다고 본다.
* 2) 10명 학생의 시험 점수 : 답 : Map 이유) 단순히 시험 점수만 나열해야한다면 List지만, 각 학생별로 점수를 파악해야 하기 때문에 학생의 이름을 Key값으로 잡고 점수를 Value값으로 가져 간다.
* 3) 대한민국의 도시별 인구수(순서 상관없음) 답: Map 이유) 도시별로 인구수를 알아야하기 때문에 도시의 이름을 Key값으로 가져가고 인구수를 value값으로 가져 간다.
*
* */

class Human(
    val name: String,
    val age: Int,
)

fun main() {
    /*
    * 연습문제 2번
    * 1) 이름을 가지는 Person 클래스를 작성하시오. Person은 반드시 이름을 포함해야 합니다.
    * 2) 이름이 '홍길동', '한석봉'인 Person 인스턴스를 생성하고 List에 담습니다.
    * 3) List에 담긴 모든 Person 인스턴스의 이름을 표시하시오 */

    val humanList = listOf(Human("홍길동", 20), Human("한석봉", 25))
    humanList.forEach { human ->
        println(human.name)
    }

    /*
    * 연습문제 3번
    * 연습문제 2번에서 작성한 Person 클래스로 생성한 '홍길동', '한석봉'의 나이를 각각 20, 25살 이라고 할때, 이름과 나이를 쌍으로 적당한 컬렉션에 넣습니다
    * 그다음 컬렉션에 저장한 값을 하나씩 다음과 같이 출력합니다.
    * "홍길동의 나이는 20살"
    * "한석봉의 나이는 25살"
    *
     */
    humanList.associate { it.name to it.age }.forEach { human ->
        println("${human.key}의 나이는 ${human.value}살")
    }
}