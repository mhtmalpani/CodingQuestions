/**
 * This problem was asked by Amazon.
 *
 * Given an integer k and a string s, find the length of the longest substring that contains at most k distinct characters.
 *
 * For example, given s = "abcba" and k = 2, the longest substring with k distinct characters is "bcb".
 *
 *
 * Reference:
 * https://www.geeksforgeeks.org/find-the-longest-substring-with-k-unique-characters-in-a-given-string/
 */

class KUniquesSubstring {

    companion object {
        private const val CHAR_SIZE = 26
        private const val START_CHAR = 'a'
    }


    private fun isValidSubstring(charArray: IntArray, k: Int): Boolean {
        val count = charArray.count {
            it != 0
        }

        return count <= k
    }

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //                                             Generic Solution                                           //
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////
    fun findKUniqueSubstring(string: String, k: Int): String {

        //Prepare to see if the string even has k unique letters
        if (k <= 0)
            return "k should be greater than 0"

        val charArray = IntArray(CHAR_SIZE) { 0 }


        //Find the longest substring with at most k uniques
        charArray.fill(0)

        var startIndex = 0
        var maxStart = 0
        var maxLength = 1


        for (endIndex in 0 until string.length) {
            charArray[string[endIndex] - START_CHAR]++

            //Remove the start value till the window does fits the criteria
            while (!isValidSubstring(charArray, k)) {
                charArray[string[startIndex] - START_CHAR]--
                startIndex++
            }

            //Update max substring details
            if (endIndex - startIndex + 1 > maxLength) {
                maxLength = endIndex - startIndex + 1
                maxStart = startIndex
            }
        }

        return string.substring(maxStart, maxStart + maxLength)
    }


    /////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //                                              Mohit's Solution                                           //
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////
    fun getKUniqueSubstring(string: String, k: Int): String {

        //Prepare to see if the string even has k unique letters
        if (k <= 0)
            return "k should be greater than 0"

        val charArray = IntArray(CHAR_SIZE) { 0 }

        var startIndex = 0
        var endIndex = 0

        var maxStart = 0
        var maxLength = 1


        while (endIndex < string.length) {
            charArray[string[endIndex] - START_CHAR]++
            endIndex++


            if (isValidSubstring(charArray, k)) {

                if (endIndex - startIndex > maxLength) {
                    maxLength = endIndex - startIndex
                    maxStart = startIndex
                }

            } else {
                charArray[string[startIndex] - START_CHAR]--
                startIndex++
            }
        }

        return string.substring(maxStart, maxStart + maxLength)
    }
}