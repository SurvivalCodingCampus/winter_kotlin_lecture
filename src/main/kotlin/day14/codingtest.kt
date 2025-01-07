package day14

import kotlin.math.max

fun main() {
    var arrayString: Array<String> = arrayOf("muzi", "ryan", "frodo", "neo")
    var gifts: Array<String> = arrayOf("muzi frodo", "muzi frodo", "ryan muzi", "ryan muzi", "ryan muzi", "frodo muzi", "frodo ryan", "neo muzi")
    solution(arrayString, gifts)
}

fun solution(friends: Array<String>, gifts: Array<String>): Int {
    val table = mutableMapOf<String, MutableMap<String, Int>>()
    val giveTable = mutableMapOf<String, Int>()
    val receiveTable = mutableMapOf<String, Int>()
    val presentIndex = mutableMapOf<String, Int>()

    for(i in friends.indices) {
        table.put(friends[i], mutableMapOf())
        giveTable.put(friends[i], 0)
        receiveTable.put(friends[i], 0)
        presentIndex.put(friends[i], 0)
    }

    for(name in friends) {
        for(i in friends.indices) {
            table[name]!!.put(friends[i], 0)
        }
    }

    //lateinit var list: List<String>
    for(i in gifts.indices) {
        val list = gifts[i].split(" ")
        table[list[0]]!![list[1]] = table[list[0]]!![list[1]]!! + 1
        //table[list[0]]!![list[1]]?.plus(1)
    }



//    print("ryan: ")
//    for(string in friends) {
//        print("${table["ryan"]?.get(string)} ")
//    }

    // 더 많이 준 대상에게 +1
    // 동일하다면 선물지수로 비교
    // 우선 선물 지수를 구해야 한다.

    for(string in friends) {
        for(string2 in friends) {
            giveTable[string] = giveTable[string]!! + table[string]?.get(string2)!!
        }
    }
    for(string in friends) {
        for(string2 in friends) {
            receiveTable[string] = receiveTable[string]!! + table[string2]?.get(string)!!
        }
    }

    for(string in friends) {
        presentIndex[string] = giveTable[string]!! - receiveTable[string]!!
    }

    val nextPresent = mutableMapOf<String, Int>()
    for(string in friends) {
        nextPresent.put(string, 0)
    }

    var turn = false
    for(giver in friends){
        for(receiver in friends) {
            if(giver == receiver) continue

            if(table[giver]!![receiver] == table[receiver]!![giver]) {
                if(presentIndex[giver]!! > presentIndex[receiver]!!) {
                    nextPresent[giver] = nextPresent[giver]!! + 1
                    continue
                }
            }
//            else if(presentIndex[giver]!! < presentIndex[receiver]!!){
//                nextPresent[receiver] = nextPresent[receiver]!! + 1
//                continue
//            }

            if(table[giver]!![receiver]!! > table[receiver]!![giver]!!) {
                nextPresent[giver] = nextPresent[giver]!! + 1
                continue
            }
//            else {
//                nextPresent[receiver] = nextPresent[receiver]!! + 1
//                continue
//            }
        }
    }

    var answer: Int = nextPresent[friends[0]]!!

    for(i in friends.indices) {
        if(answer < nextPresent[friends[i]]!!) {
            answer = nextPresent[friends[i]]!!
        }
    }

    return answer
}