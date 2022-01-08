package google

class MinimumSubstringContainingGivenString {

    private val hashMap: HashMap<Char, Int> = hashMapOf()

    fun getSubstring(input: String, pattern: String): String {

        val inputArray = input.toCharArray()
        val patternArray = pattern.toCharArray()

        var count = 0

        var minStart = 0
        var minLength = Int.MAX_VALUE

        var i = 0
        var j = 0

        patternArray.forEach {
            if (hashMap.contains(it))
                hashMap[it] = hashMap.getValue(it) + 1
            else {
                hashMap[it] = 1
                count++
            }
        }

        while (j < inputArray.size) {

            if (doesExistInPattern(inputArray[j])) {
                hashMap[inputArray[j]] = hashMap.getValue(inputArray[j]) - 1

                if (hashMap.getValue(inputArray[j]) == 0) {
                    count--
                }
            }

            if (count == 0) {

                while (count == 0) {

                    val length = j - i + 1

                    if (minLength > length) {
                        minStart = i
                        minLength = length
                    }

                    if (doesExistInPattern(inputArray[i])) {
                        hashMap[inputArray[i]] = hashMap.getValue(inputArray[i]) + 1

                        if (hashMap.getValue(inputArray[i]) > 0)
                            count++
                    }

                    i++
                }
            }
            j++
        }

        return input.substring(minStart, minStart + minLength)
    }

    private fun doesExistInPattern(char: Char): Boolean {
        return hashMap.contains(char)
    }
}

fun main() {

    val minimumSubstringContainingGivenString = MinimumSubstringContainingGivenString()

    println(minimumSubstringContainingGivenString.getSubstring("abcdefgh", "defb"))
    println(minimumSubstringContainingGivenString.getSubstring("fhsdidsdasid", "ss"))
    println(minimumSubstringContainingGivenString.getSubstring("agdddddjsiffhsasdddgasgawassdgf", "sad"))
}