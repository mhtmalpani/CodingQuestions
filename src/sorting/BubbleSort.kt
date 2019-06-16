package sorting

// Pushing the largest element to the bottom of the list
fun bubbleSort(data: ArrayList<Int>): ArrayList<Int> {

    var temp: Int

    for (pass in data.size - 1 downTo 0) {
        for (i in 0 until pass) {
            if (data[i] > data[i + 1]) {
                temp = data[i]
                data[i] = data[i + 1]
                data[i + 1] = temp
            }
        }
    }

    return data
}

fun bubbleSortWithPrinting(data: ArrayList<Int>): ArrayList<Int> {

    var temp: Int

    for (pass in data.size - 1 downTo 0) {
        for (i in 0 until pass) {
            if (data[i] > data[i + 1]) {
                temp = data[i]
                data[i] = data[i + 1]
                data[i + 1] = temp
            }
            println("Pass: $pass & i: $i")
            println(data)
        }
        println()
    }

    return data
}

/**
 * This is the improvised version of BubbleSort.
 * This will stop iterating when it observes that no element is swapped and the array is sorted.
 */
fun bubbleSortImprovised(data: ArrayList<Int>): ArrayList<Int> {

    var temp: Int

    //Default is considering that at least one value will be swapped
    var isAnyValueSwapped: Boolean

    for (pass in data.size - 1 downTo 0) {
        isAnyValueSwapped = false
        for (i in 0 until pass) {
            if (data[i] > data[i + 1]) {
                temp = data[i]
                data[i] = data[i + 1]
                data[i + 1] = temp
                isAnyValueSwapped = true
            }
        }
        if (!isAnyValueSwapped) break
    }

    return data
}