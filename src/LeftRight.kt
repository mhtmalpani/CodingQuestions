/**
 * Given an array of numbers, print the numbers is a new fashion.
 *
 * First, print the number in the middle of the array.
 *
 * If the number was EVEN, print the next number in the array (to the right)
 * If the number was ODD, print the previous number in the array (to the left)
 *
 * At any time if you reach the end of the array and need to go further towards
 * the extreme, you need to bounce back
 *
 * e.g.
 * 1.
 * Input:   7, 5, 2, 3, 4, 8, 1, 6, 9
 * Output:  4, 8, 1, 3, 2, 6, 9, 5, 7
 *
 * 2.
 * Input:   9, 3, 6, 8
 * Output:  6, 8, 3, 9
 *
 * 3.
 * Input:   3, 9, 7, 6, 4, 5, 1, 2, 8
 * Output:  4, 5, 6, 1, 7, 9, 3, 2, 8
 */


class LeftRight {

    private var current: Int = 0
    private var left: Int = 0
    private var right: Int = 0
    private var size: Int = 0

    fun compute(array: Array<Int>): List<Int> {

        size = array.size
        val result = mutableListOf<Int>()

        current = size / 2

        left = current - 1
        right = current + 1

        while (true) {

            if (current < 0 || current >= size)
                break

            val element = array[current]

            result.add(element)

            if (element % 2 == 0) {
                if (canGoRight())
                    goRight()
                else
                    goLeft()
            } else {
                if (canGoLeft())
                    goLeft()
                else
                    goRight()
            }
        }

        return result.toList()
    }

    private fun canGoRight(): Boolean {
        return right < size
    }

    private fun goRight() {
        current = right
        right += 1
    }

    private fun canGoLeft(): Boolean {
        return left >= 0
    }

    private fun goLeft() {
        current = left
        left -= 1
    }

}