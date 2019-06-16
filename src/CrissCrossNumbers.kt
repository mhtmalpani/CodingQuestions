/**
 *
 * Problem statement:
 *
 * Given a list of numbers:
 * Make a new list that follows the conditions:
 * a. Every odd index value must be smaller than all previous elements
 * b. Every even index value must be greater than all previous elements
 *
 * Note: The numbers can repeat itself
 *
 *
 *
 * Sample Data:
 *
 * Input:  5, 2, 30, 4, 12, 9, 1, 7, 25
 *
 * Output: 7, 5, 9, 4, 12, 2, 25, 1, 30
 * Index:  0, 1, 2, 3, 4,  5, 6,  7, 8
 *
 */

class CrissCrossNumbers {

    fun execute(input: List<Int>): List<Int> {

        val mid = input.size / 2

        val data = input.sorted()

        val result = mutableListOf<Int>()

        var i = mid - 1
        var j = mid

        while (i >= 0 && j < data.size) {
            result.add(data[j++])
            result.add(data[i--])
        }

        if (data.size % 2 != 0)
            result.add(data[j])

        return result
    }
}
