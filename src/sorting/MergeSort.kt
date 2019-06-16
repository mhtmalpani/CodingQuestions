package sorting


fun mergeSortData(data: ArrayList<Int>): ArrayList<Int> {

    performMergeSortData(data)

    return data
}

private fun performMergeSortData(data: ArrayList<Int>) {

    mergeSort(data, 0, data.size - 1)
}

private fun mergeSort(A: ArrayList<Int>, left: Int, right: Int) {

    if (left < right) {

        val mid = (left + right) / 2

        mergeSort(A, left, mid)
        mergeSort(A, mid + 1, right)

        mergeArrays(A, left, mid, right)
    }
}

private fun mergeArrays(A: ArrayList<Int>, left: Int, mid: Int, right: Int) {

    //Find the size of the two halves of the arrays
    val leftArraySize = mid + 1 - left
    val rightArraySize = right - mid


    //Create two temporary arrays
    val leftArray = ArrayList<Int>()
    val rightArray = ArrayList<Int>()


    //Copy to temporary arrays
    for (i in 0 until leftArraySize) {
        leftArray.add(A[left + i])
    }

    for (j in 0 until rightArraySize) {
        rightArray.add(A[mid + 1 + j])
    }


    //Create indexes for iteration
    var i = 0
    var j = 0
    var k = left


    //Merge the two arrays in sorted order
    while (i < leftArraySize && j < rightArraySize) {

        if (leftArray[i] <= rightArray[j]) {
            A[k] = leftArray[i]
            i++
        } else {
            A[k] = rightArray[j]
            j++
        }

        k++
    }


    //Copy remaining elements if any
    while (i < leftArraySize) {
        A[k] = leftArray[i]
        k++
        i++
    }

    while (j < rightArraySize) {
        A[k] = rightArray[j]
        k++
        j++
    }

}

