package sorting


fun shellSortData(data: ArrayList<Int>): ArrayList<Int> {

    shellSort(data)

    return data
}


private fun shellSort(A: ArrayList<Int>) {
    val n = A.size

    // Start with a big gap, then reduce the gap
    var gap = n / 2

    while (gap > 0) {
        // Do a gapped insertion sort for this gap size.
        // The first gap elements a[0..gap-1] are already in gapped order keep adding one more element
        // until the entire array is gap sorted
        var i = gap
        while (i < n) {
            // Add a[i] to the elements that have been gap
            // sorted save a[i] in temp and make a hole at position i
            val temp = A[i]

            // Shift earlier gap-sorted elements up until the correct location for a[i] is found
            var j: Int = i
            while (j >= gap && A[j - gap] > temp) {
                A[j] = A[j - gap]
                j -= gap
            }

            // Put temp (the original a[i]) in its correct location
            A[j] = temp
            i += 1
        }
        gap /= 2
    }
}