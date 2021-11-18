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

class GridTraveller {

    fun getNumberOfWaysToTravel(n: Int, m: Int): Long {

        //Base case
        if (n == 1 && m == 1)
            return 1

        if (n == 0 || m == 0)
            return 0

        return getNumberOfWaysToTravel(n - 1, m) + getNumberOfWaysToTravel(n, m - 1)
    }

}