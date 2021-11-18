/**
 * Find out the number of ways to travel from the top left end
 * to the bottom right end of a (n x m) board
 *
 * Constraint: You can travel only right or down
 *
 * -------------
 * | s |   |   |
 * -------------
 * |   |   | e |
 * -------------
 *
 * This is a 2 x 3 board. s and e are the start and end points respectively
 *
 * The number of ways to reach the end from start is 3
 *
 */

class GridTravellerMemoization {

    private val memo = HashMap<String, Long>()

    fun getNumberOfWaysToTravel(n: Int, m: Int): Long {

        val key = getBoardKey(n, m)

        //Check in memo
        if (memo.contains(key))
            return memo.getValue(key)

        //Base case
        if (n == 1 && m == 1)
            return 1

        if (n == 0 || m == 0)
            return 0

        memo[key] = getNumberOfWaysToTravel(n - 1, m) + getNumberOfWaysToTravel(n, m - 1)

        return memo.getValue(key)
    }

    private fun getBoardKey(n: Int, m: Int): String {
        return if (n < m) "$n:$m" else "$m:$n"
    }

}