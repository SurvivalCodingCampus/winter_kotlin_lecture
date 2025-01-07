//package day14
//// 두 사람이 선물을 주고받은 기록이 있다면, 이번 달까지 두 사람 사이에 더 많은 선물을 준 사람이 다음 달에 선물을 하나 받습니다.
//// 두 사람이 선물을 주고받은 기록이 하나도 없거나 주고받은 수가 같다면, 선물 지수가 더 큰 사람이 선물 지수가 더 작은 사람에게 선물을 하나 받습니다.
//// 선물 지수는 이번 달까지 자신이 친구들에게 준 선물의 수에서 받은 선물의 수를 뺀 값입니다.
//// 만약 두 사람의 선물 지수도 같다면 다음 달에 선물을 주고받지 않습니다.
//fun main() {
////    var answer: Int = 0
////    val map: MutableMap<String, String> = mutableMapOf()
////    gifts.forEach {
////        val str = it.split(" ")
////        map.put(str[0], str[1])
////    }
//
//
//    // val test = gifts.groupBy(String::first).keys
//
////    val receiveMuzi = map.filter{ (key, value) -> value.contains("muzi")}
////    val ms = receiveMuzi.size
////    println(ms)
////    val receiveRyan = map.filter{ (key, value) -> value.contains("ryan")}
////    val rs = receiveRyan.size
////    val receiveFrodo = map.filter{ (key, value) -> value.contains("frodo")}
////    val fs = receiveFrodo.size
////    val receiveNeo = map.filter{ (key, value) -> value.contains("neo")}
////    val ns = receiveNeo.size
//
//    val solution = Solution()
//    solution.solution(arrayOf("muzi", "ryan", "frodo", "neo"), arrayOf("muzi frodo", "muzi frodo", "ryan muzi", "ryan muzi", "ryan muzi", "frodo muzi", "frodo ryan", "neo muzi"))
//
//}
//
//class Solution {
//    fun solution(friends: Array<String>, gifts: Array<String>): Int {
//        var answer: Int = 0
//        val testList = gifts.map { it.split(" ") }.groupingBy { it }.eachCount()
//        println(testList)
//        // 각각 리스트로 다시 담자 그다음 비교하자. 받은사람이랑 준 사람 이름이 동일하면 숫자 비교 진행되게.
//        val person: List<List<String>> = testList.keys.toList()
//        val count: List<Int> = testList.values.toList()
//        val giver:List<String> =
//        val receiver:List<String> =
//        println("기버 $giver")
//        println(("리시버 $receiver"))
//        println(count)
//
////        var muziCount = 0
////        testList.forEach { data -> println("값: ${data.key[0]}")
////            if(data.key[0] == "muzi") && (data.key[1] == "muzi") {
////
////            }
////        }
//
//
//
//
//        return 0
//    }
//}
//
