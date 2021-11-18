/**
 * Given a target and a set of Integer values,
 * determine if the target can be achieved by adding one or more values in the list
 *
 * Note: We can reuse the same value multiple times
 *
 * Example:
 *
 * target = 7
 * values = (2, 3, 4, 7)
 *
 * We shall return True
 * Reason: We could build 7 using (3+4) or just (7)
 */

class CanSum {

    fun canSumWithValues(target: Int, values: IntArray): Boolean {

        if (target == 0)
            return true

        if (target < 0)
            return false

        values.forEach { value ->
            val remainder = target - value
            if (canSumWithValues(remainder, values))
                return true
        }

        return false
    }
}