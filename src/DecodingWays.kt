/**
 *
 * This problem was asked by Facebook.
 *
 * Given the mapping a = 1, b = 2, ... z = 26, and an encoded message, count the number of ways it can be decoded.
 *
 * For example, the message '111' would give 3, since it could be decoded as 'aaa', 'ka', and 'ak'.
 *
 * You can assume that the messages are decodable. For example, '001' is not allowed.
 *
 * Reference:
 * https://www.youtube.com/watch?v=qli-JCrSwuk&list=PLBZBJbE_rGRVnpitdvpdY9952IsKMDuev
 *
 **/

/**
 * Logic:
 * decode("12345") =
 *      'a' + decode("2345")
 *              +
 *      'l' + decode("345")
 *
 *
 * decode("2789") =
 *      'b' + decode("789")
 *
 *
 * When we have a number <=26, we can compute the number itself
 *
 */

class DecodingWays {

    fun numberOfWays(data: String): Int {
        return decodeHelper(data, data.length)
    }


    //Complexity: O(2^N)
    private fun decodeHelper(data: String, k: Int): Int {

        //Base case: Empty string
        if (k == 0)
            return 1

        //Get the starting index of string for this calculation
        val s = data.length - k

        //Case when the the starting index is 0
        //There is no such possibility, so 0 ways
        if (data[s] == '0')
            return 0


        var result = decodeHelper(data, k - 1)

        if (k >= 2 && data.substring(s, s + 2).toInt() <= 26)
            result += decodeHelper(data, k - 2)

        return result
    }


    fun decodedStrings(data: String) {
        decodeFinder("", data, data.length)
    }

    private fun decodeFinder(current: String, data: String, k: Int) {

        if (k == 0) {
            println(current)
            return
        }

        val s = data.length - k

        if (data[s] == '0')
            return

        decodeFinder(current + converter(Character.getNumericValue(data[s])), data, k - 1)

        if (k >= 2 && data.substring(s, s + 2).toInt() <= 26)
            decodeFinder(current + converter(Integer.parseInt(data.substring(s, s + 2))), data, k - 2)
    }


    private fun converter(number: Int): Char {
        return (number + 96).toChar()
    }


    fun numberOfWaysDynamicApproach(data: String): Int {
        val memo = Array(data.length + 1) { -1 }
        return decodeHelperDynamicApproach(data, data.length, memo)
    }


    private fun decodeHelperDynamicApproach(data: String, k: Int, memo: Array<Int>): Int {

        //Base case: Empty string
        if (k == 0)
            return 1

        //Get the starting index of string for this calculation
        val s = data.length - k

        //Case when the the starting index is 0
        //There is no such possibility, so 0 ways
        if (data[s] == '0')
            return 0


        //If we have this value already computed, just return it
        if (memo[k] != -1)
            return memo[k]


        var result = decodeHelperDynamicApproach(data, k - 1, memo)

        if (k >= 2 && data.substring(s, s + 2).toInt() <= 26)
            result += decodeHelperDynamicApproach(data, k - 2, memo)

        memo[k] = result

        return result
    }

}

