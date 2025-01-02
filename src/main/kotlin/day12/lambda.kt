package day12


fun main() {
    listOf(3, 2, 1).sortedWith { o1, o2 -> o1 - o2 }


    val result = listOf(1, 2, 3).first { it < 2 }
    println(result)


    // filter
    val items = listOf(1, 2, 3, 4, 5)

    for (item in items) {
        if (item % 2 == 0) {
            print(item)
        }
    }

    // forEach

    val testList = listOf(1, 2, 3, 4, 5, 6, 7, 8)

    testList.forEach { item ->
        if(item % 2 == 0) {
            return@forEach
        }

        print(" $item")
    }
}


class MyComparator : Comparator<Int> {
    override fun compare(o1: Int?, o2: Int?): Int {
        return o1!! - o2!!
    }

}
