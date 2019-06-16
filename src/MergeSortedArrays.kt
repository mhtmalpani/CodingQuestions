/**
 * Problem statement:
 *
 * Given 2 Sorted arrays, compute a merged sorted array.
 *
 * Sample Input:
 * Array A ->
 *          1, 3, 5, 7
 * Array B ->
 *          2, 4, 6
 *
 *
 * Output:
 *          1, 2, 3, 4, 5, 6, 7
 */


class MergeSortedArrays {

    fun mergeArraySorted(first: ArrayList<Int>, second: ArrayList<Int>, reverse: Boolean = false): ArrayList<Int> {

        val merged = ArrayList<Int>(first.size + second.size)

        //Index for First array
        var i = 0

        //Index for Second array
        var j = 0


        while (i < first.size && j < second.size)
            merged.add(if (first[i] <= second[j]) first[i++] else second[j++])

        while (i < first.size)
            merged.add(first[i++])

        while (j < second.size)
            merged.add(second[j++])


        if (reverse) {
            for (k in 0 until merged.size / 2) {
                merged.swap(k, merged.size - 1 - k)
            }
        }

        return merged
    }

    fun mergeArraySortedReversed(first: ArrayList<Int>, second: ArrayList<Int>): ArrayList<Int> {

        val merged = ArrayList<Int>(first.size + second.size)

        //Index for First array
        var i = first.size - 1

        //Index for Second array
        var j = second.size - 1


        while (i >= 0 && j >= 0)
            merged.add(if (first[i] >= second[j]) first[i--] else second[j--])

        while (i >= 0)
            merged.add(first[i--])

        while (j >= 0)
            merged.add(second[j--])

        return merged
    }

    //Extension function
    private fun <T> ArrayList<T>.swap(first: Int, second: Int) {
        val temp = this[first]
        this[first] = this[second]
        this[second] = temp
    }
}