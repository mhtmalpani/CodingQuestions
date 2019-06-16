package sorting


fun mergeSortDataAdvanced(data: ArrayList<Int>): ArrayList<Int> {

    performMergeSortAdvanced(data)

    return data
}

private fun performMergeSortAdvanced(data: ArrayList<Int>) {

    mergeSortAdvanced(data, 0, data.size - 1)
}

private fun mergeSortAdvanced(A: ArrayList<Int>, left: Int, right: Int) {

    if (left < right) {

        val mid = (left + right) / 2

        mergeSortAdvanced(A, left, mid)
        mergeSortAdvanced(A, mid + 1, right)

        mergeArraysAdvanced(A, left, mid + 1, right)
    }
}

private fun mergeArraysAdvanced(A: ArrayList<Int>, left: Int, mid: Int, right: Int) {

    //Temporary array
    val T = ArrayList<Int>()

    /**
     * i=left _____________ j=mid _____________ right
     */
    var i = left
    var j = mid

    while (i < mid && j <= right) {
        T.add(if (A[i] <= A[j]) A[i++] else A[j++])
    }

    //Copy remaining elements if any
    while (i < mid) T.add(A[i++])

    while (j <= right) T.add(A[j++])


    val size = right - left + 1
    var l = left

    (0 until size).forEach {
        A[l++] = T[it]
    }
}