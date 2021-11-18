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

class CanSumMemoization {

    private val memo = HashMap<Int, Boolean>()

    fun canSumWithValues(target: Int, values: IntArray): Boolean {

        //Check in memo first
        if (memo.contains(target))
            return memo.getValue(target)

        //Base Cases

        //Return true if the target reached is 0 by deducting the array values
        if (target == 0)
            return true

        //If the target has reached negative, we have passed the limit in the tree branch
        if (target < 0)
            return false

        //Computation
        values.forEach { value ->
            val remainder = target - value
            if (canSumWithValues(remainder, values)) {
                memo[remainder] = true
                return true
            }
        }


        memo[target] = false
        return false
    }
}