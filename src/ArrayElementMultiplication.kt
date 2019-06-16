/**
 * Problem:
 *
 * Given an array of integers, return a new array such that each element at index i of the new array
 * is the product of all the numbers in the original array except the one at i.
 *
 * For example, if our input was [1, 2, 3, 4, 5], the expected output would be [120, 60, 40, 30, 24].
 * If our input was [3, 2, 1], the expected output would be [2, 3, 6].
 *
 * Follow-up: what if you can't use division?
 *
 * Bonus: Consider one or multiple zeros as boundary cases
 */
class ArrayElementMultiplication {

    fun execute(data: IntArray): IntArray {

        var product = 1

        data.forEach {
            product *= it
        }

        return data.map {
            product / it
        }.toIntArray()
    }


    fun executeWithZero(data: IntArray): IntArray {

        var product = 1

        val countOfZero = data.filter { it == 0 }.size

        when (countOfZero) {
            0 -> {
                data.forEach {
                    product *= it
                }

                return data.map {
                    product / it
                }.toIntArray()
            }
            1 -> {
                data.forEach {
                    if (it != 0)
                        product *= it
                }

                return data.map {
                    if (it != 0) 0 else product
                }.toIntArray()
            }
            else -> {
                return data.map { 0 }.toIntArray()
            }
        }
    }


    /*
    Input   1   2   3   4   5
    Output  120 60  40  30  24

    Left    1           1           1*2         1*2*3           1*2*3*4
    Right   2*3*4*5     3*4*5       4*5         5               1
     */
    fun executeWithoutDivision(data: IntArray): IntArray {

        if (data.isEmpty()) return intArrayOf()

        //Array to hold product of all elements before (left of) i'th element
        val left = IntArray(data.size)
        //Array to hold product of all elements after (right of) i'th element
        val right = IntArray(data.size)

        //Defaults
        left[0] = 1
        right[data.size - 1] = 1

        for (i in 1 until data.size)
            left[i] = left[i - 1] * data[i - 1]

        for (j in data.size - 2 downTo 0)
            right[j] = right[j + 1] * data[j + 1]

        return data.mapIndexed { index, _ ->
            left[index] * right[index]
        }.toIntArray()
    }

}