package Google

/**
 * Given an array of size n, find the majority element. The majority element is the element that appears more than floor(n/2) times.
 * You may assume that the array is non-empty and the majority element always exist in the array.
 *
 * Example :
 *
 * Input : [2, 1, 2]
 * Return  : 2 which occurs 2 times which is greater than 3/2.
 */

class MajorityElementFinder {

    /**
     * Solution explanation:
     *
     * 1. With odd size
     * Input: [2, 1, 2]
     * Sorted: [1, 2, 2]
     *
     * Take index: 3/2 = 1
     *
     * 2. With even size
     * Input: [5, 5, 5, 1, 1, 1, 9, 7, 1, 1, 1, 1, 5, 1]
     * Sorted: [1, 1, 1, 1, 1, 1, 1, 1, 5, 5, 5, 5, 7, 9]
     *
     * Take: index: 14/2 = 7
     *
     * Logic: The value is guaranteed to be present in the middle of the sorted array
     */

    fun getMajorityElement(data: Array<Int>): Int {
        println(data.sorted())
        return data.sorted()[data.size / 2]
    }
}

fun main() {
    val majorityElementFinder = MajorityElementFinder()

//    val data = arrayOf(1, 2, 2, 2, 3, 4, 5, 2, 2, 4, 4, 2, 1, 2, 2)
    val data = arrayOf(5, 5, 5, 1, 1, 1, 9, 7, 1, 1, 1, 1, 5, 1)

    println(majorityElementFinder.getMajorityElement(data))
}