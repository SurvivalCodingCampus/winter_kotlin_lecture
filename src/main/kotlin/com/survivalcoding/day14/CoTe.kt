package com.survivalcoding.com.survivalcoding.day14

fun main() {
    val solution = Solution()
    println(
        solution.solution(
            arrayOf("muzi", "ryan", "frodo", "neo"),
            arrayOf(
                "muzi frodo",
                "muzi frodo",
                "ryan muzi",
                "ryan muzi",
                "ryan muzi",
                "frodo muzi",
                "frodo ryan",
                "neo muzi"
            )
        )
    )

}

class Solution {
    private val giftManager = GiftManager()

    fun solution(friends: Array<String>, gifts: Array<String>): Int {
        friends.forEach {
            giftManager.friends.add(Person(it))
        }
        gifts.forEach {
            val from = it.split(" ")[0]
            val to = it.split(" ")[1]
            giftManager.gifts.add(Gift(Person(from), Person(to)))
        }
        return 0
    }
}

class GiftManager {
    val friends = mutableListOf<Person>()
    val gifts = mutableListOf<Gift>()

    fun calc() {
        gifts.forEach {

        }
    }

    fun bonus(person1: Person, person2: Person) {
        if (person1.sendAny(person2) && person2.sendAny(person1)) {
            if (person1 < person2) {
                person1.send(person2)
            } else if (person1 > person2) {
                person2.send(person1)
            }
        }

        if ((person1.sendAny(person2) && person2.sendAny(person1)).not()
                .or(person1.sendCount(person2) == person2.sendCount(person1))
        ) {
            if (person1.score() == person2.score()) {
                return
            }

            val win = if (person1.score() > person2.score()) {
                person1
            } else {
                person2
            }

            val loser = if (person1.score() < person2.score()) {
                person1
            } else {
                person2
            }

            loser.send(win)
        }

    }
}

data class Gift(
    val from: Person,
    val to: Person,
) {
    override fun toString(): String {
        return "$from $to"
    }
}

data class Person(
    val name: String,
) : Comparable<Person> {
    // 내가 보낸 사람
    val senders = mutableListOf<Person>()

    // 나한테 준 사람
    val giftFroms = mutableListOf<Person>()

    fun send(person: Person) {
        senders.add(person)
    }

    fun from(person: Person) {
        giftFroms.add(person)
    }

    fun sendCount(person: Person): Int {
        return senders.filter { it == person }.size
    }

    fun fromCount(person: Person): Int {
        return giftFroms.filter { it == person }.size
    }

    fun sendAny(person: Person): Boolean {
        return senders.any { it == person }
    }

    fun fromAny(person: Person): Boolean {
        return giftFroms.any { it == person }
    }

    fun score(): Int {
        return senders.size - giftFroms.size
    }

    override fun compareTo(other: Person): Int {
        return sendCount(other).compareTo(other.sendCount(this))
    }

    override fun toString(): String {
        return name
    }
}