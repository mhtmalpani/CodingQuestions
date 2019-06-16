package sorting

/**
 * For Input:
 * [2, 4, 1, 5, 3]
 *
 *
 * Execution:
 * [2, 4, 1, 5, 3]
 * [1, 4, 2, 5, 3]
 * [1, 2, 4, 5, 3]
 * [1, 2, 3, 5, 4]
 * [1, 2, 3, 4, 5]
 */

/**
 * Select the smallest value in the list and swap it with the current index.
 * Increase index gradually from first position to the last.
 */
fun selectionSort(data: ArrayList<Int>): ArrayList<Int> {

    var min: Int

    for (i in 0 until data.size - 1) {
        min = i
        for (j in i + 1 until data.size) {
            if (data[j] < data[min]) {
                min = j
            }
        }
        swapData(data, i, min)
    }

    return data
}

private fun swapData(data: ArrayList<Int>, i: Int, min: Int) {
    val temp = data[i]
    data[i] = data[min]
    data[min] = temp
}

fun selectionSortWithPrinting(data: ArrayList<Int>): ArrayList<Int> {

    var min: Int

    for (i in 0 until data.size - 1) {
        min = i
        println(data)
        for (j in i + 1 until data.size) {
            if (data[j] < data[min]) {
                min = j
            }
        }
        swapData(data, i, min)
    }

    return data
}

