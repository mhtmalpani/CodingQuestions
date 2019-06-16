package sorting

/**
 * Each value is considered from the second index position
 * It is then compared and inserted in the correct location of the left half of the array
 *
 * | <x | >x | x | abc
 * will be converted to
 * | <x | x | >x | abc
 *
 * The left half of the index in computation will always be sorted array
 */
fun insertionSort(data: ArrayList<Int>): ArrayList<Int> {

    var vertex: Int
    var k: Int

    for (i in 1 until data.size) {
        vertex = data[i]
        k = i

        while (k >= 1 && data[k - 1] > vertex) {
            data[k] = data[k - 1]
            k--
        }
        data[k] = vertex
    }

    return data
}

fun insertionSortWithPrint(data: ArrayList<Int>): ArrayList<Int> {

    var vertex: Int
    var k: Int

    for (i in 1 until data.size) {
        vertex = data[i]
        k = i

        while (k >= 1 && data[k - 1] > vertex) {
            data[k] = data[k - 1]
            k--
        }
        data[k] = vertex

        println(vertex)
        println(data)
    }

    return data
}