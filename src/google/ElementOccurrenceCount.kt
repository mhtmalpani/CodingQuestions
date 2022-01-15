package google


class ElementOccurrenceCount {

    fun getData(list: List<Int>): Map<Int, Int> {
        val data = mutableMapOf<Int, Int>()
        list.distinct().forEach {
            data[it] = list.count { x -> x == it }
        }

        return data
    }

}

fun main() {
    val elementOccurrenceCount = ElementOccurrenceCount()

//    val data = arrayOf(1, 2, 2, 2, 3, 4, 5, 2, 2, 4, 4, 2, 1, 2, 2)
    val data = listOf(5, 5, 5, 1, 1, 1, 9, 7, 1, 1, 1, 1, 5, 1)

    println(elementOccurrenceCount.getData(data))
}