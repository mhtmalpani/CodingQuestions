class PowerSet {

    fun generate(set: CharArray): MutableList<String> {
        val n = set.size

        val powerSetList: MutableList<String> = mutableListOf()

        // Run a loop for printing all 2^n
        // subsets one by one
        for (i in 0 until (1 shl n)) {

            val setValue = StringBuilder()

            // Print current subset
            for (j in 0 until n)
            // (1<<j) is a number with jth bit 1
            // so when we 'and' them with the
            // subset number we get which numbers
            // are present in the subset and which
            // are not
                if (i and (1 shl j) > 0) setValue.append(set[j])

            powerSetList.add(setValue.toString())
        }

        return powerSetList
    }

    fun generateAndPrint(set: CharArray) {
        val n = set.size

        // Run a loop for printing all 2^n
        // subsets one by one
        for (i in 0 until (1 shl n)) {

            print("{ ")

            // Print current subset
            for (j in 0 until n)
            // (1<<j) is a number with jth bit 1
            // so when we 'and' them with the
            // subset number we get which numbers
            // are present in the subset and which
            // are not
                if (i and (1 shl j) > 0) print(set[j].toString() + " ")

            println("}")
        }
    }
}

fun main(args: Array<String>) {
    val set = charArrayOf('a', 'b', 'c')
    val powerSet = PowerSet()
    powerSet.generateAndPrint(set)

    val list = powerSet.generate(set)
    list.forEach(::println)
}