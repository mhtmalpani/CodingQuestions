/**
 * Given a target and a set of Integer values,
 * determine and return if the target can be achieved by adding one or more values in the list
 *
 * Note: We can reuse the same value multiple times
 *
 * Example:
 *
 * target = 7
 * values = (2, 3, 4, 7)
 *
 * We shall return [3, 4] or [7]
 * Reason: We could build 7 using (3+4) or just (7)
 */

class HowSumMemoization {

    private val memo = HashMap<Int, MutableList<Int>?>()

    fun howSumWithValues(target: Int, values: IntArray): MutableList<Int>? {

        if (memo.contains(target))
            return memo.getValue(target)

        if (target == 0)
            return mutableListOf()

        if (target < 0)
            return null

        values.forEach { value ->
            val remainder = target - value

            val list = howSumWithValues(remainder, values)
            if (list != null) {
                list.add(value)
                memo[target] = list
                return list
            }
        }

        memo[target] = null
        return null
    }
}