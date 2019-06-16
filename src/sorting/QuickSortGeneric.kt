package sorting



fun <T : Comparable<T>> quickSortDataGeneric(data: ArrayList<T>): ArrayList<T> {

    performQuickSortDataGeneric(data)

    return data
}


private fun <T : Comparable<T>> performQuickSortDataGeneric(data: ArrayList<T>) {

    quickSort(data, 0, data.size - 1)
}

private fun <T : Comparable<T>> quickSort(A: ArrayList<T>, low: Int, high: Int) {

    if (low < high) {

        //Place where the array has been divided in to two parts.
        //Left part has A lower to the pivot
        //Right part has the A higher to the pivot

        val pivot = partition(A, low, high)

        //Sort the left half of the array
        quickSort(A, low, pivot - 1)

        //Sort the right half of the array
        quickSort(A, pivot + 1, high)
    }
}

private fun <T : Comparable<T>> partition(A: ArrayList<T>, low: Int, high: Int): Int {

    val pivot = A[low]
    var left = low
    var right = high

    while (left < right) {

        //Increment the left till the element is higher than the pivot
        while (A[left] <= pivot && left < high) {
            left++
        }

        //Decrement the right till the element is lower than the pivot
        while (A[right] > pivot && right > low) {
            right--
        }

        //Swap the elements to place it in the correct array segment
        if (left < right) {
            swap(A, left, right)
        }
    }

    //Placing the pivot to the actual position where it should belong in the sorted array
    //i.e. the *right* value
    A[low] = A[right]
    A[right] = pivot

    //Return the pivot point to segregate the array in to two parts
    return right
}

private fun <T : Comparable<T>> swap(A: ArrayList<T>, left: Int, right: Int) {
    val temp = A[left]
    A[left] = A[right]
    A[right] = temp
}