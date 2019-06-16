/**
 * There's a staircase with N steps, and you can climb 1 or 2 steps at a time.
 * Given N, write a function that returns the number of unique ways you can climb the staircase.
 * The order of the steps matters.
 *
 * For example, if N is 4, then there are 5 unique ways:
 *
 * 1, 1, 1, 1
 * 2, 1, 1
 * 1, 2, 1
 * 1, 1, 2
 * 2, 2
 * What if, instead of being able to climb 1 or 2 steps at a time, you could climb any number from a set of positive integers X?
 * For example, if X = {1, 3, 5}, you could climb 1, 3, or 5 steps at a time. Generalize your function to take in X.
 *
 * Solution: https://www.youtube.com/watch?v=5o-kdjv7FD0
 */


class Staircase {

    fun numberOfWaysToClimbRecursive(staircase: Int): Int {
        if (staircase == 0 || staircase == 1)
            return 1

        return numberOfWaysToClimbRecursive(staircase - 1) + numberOfWaysToClimbRecursive(staircase - 2)
    }


    fun numberOfWaysToClimbRecursive(staircase: Int, stepsHops: List<Int>): Int {
        if (staircase == 0)
            return 1

        var total = 0

        stepsHops.forEach { hop ->
            if (staircase - hop >= 0)
                total += numberOfWaysToClimbRecursive(staircase - hop, stepsHops)
        }

        return total
    }


    fun numberOfWaysToClimb(staircase: Int): Int {

        if (staircase == 0) return 1

        val ways = Array(staircase + 1) { 0 }

        ways[0] = 1
        ways[1] = 1

        for (i in 2..staircase)
            ways[i] = ways[i - 1] + ways[i - 2]

        return ways[staircase]
    }

    fun numberOfWaysToClimb(staircase: Int, stepsHops: List<Int>): Int {

        val ways = Array(staircase + 1) { 0 }

        ways[0] = 1

        for (i in 1..staircase) {
            var total = 0
            stepsHops.forEach { hop ->
                if (i - hop >= 0)
                    total += ways[i - hop]
            }
            ways[i] = total
        }

        return ways[staircase]
    }
}