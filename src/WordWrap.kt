/**
 *
 * Problem Statement:
 *
 * Implement a function to wrap a string of arbitrary length with new line character
 * based on max characters allowed in each line.
 */

class WordWrap(private val LINE_BREAK: Int = 80) {

    fun wrapWithWordSplit(data: String?): String {

        data ?: return "Null String"

        //List of words that will build the paragraph
        //Split based on single or multiple spaces
        val wordList = data.split("\\s+".toRegex())

        //Big buffer to hold the entire paragraph
        val buffer = StringBuilder(data.length + (data.length / LINE_BREAK))

        //Small buffer to hold the current sentence
        val lineBuffer = StringBuilder(LINE_BREAK)


        //Loop across each word to append in buffer
        for (word in wordList) {

            if (word.length > LINE_BREAK) {
                return "Word size more than $LINE_BREAK detected"
            }

            //Add to paragraph buffer when line buffer exceeds LINE_BREAK length
            if (lineBuffer.length + word.length > LINE_BREAK) {
                buffer.append(lineBuffer.toString().trim())
                buffer.append("\n")

                //Reset line buffer
                lineBuffer.setLength(0)
            }

            lineBuffer.append(word)
            lineBuffer.append(" ")
        }

        //Add any remaining words that makes a string of length less than LINE_BREAK characters
        if (lineBuffer.isNotEmpty()) {
            buffer.append(lineBuffer.toString().trim())
            lineBuffer.setLength(0)
        }

        return buffer.toString()
    }


    fun wrapWithSpaceSearch(data: String?): String {

        data ?: return "Null String"

        var sentence = data.replace("\\s+".toRegex(), " ")

        //Big buffer to hold the entire paragraph
        val buffer = StringBuilder(data.length + (data.length / LINE_BREAK))

        while (sentence.length > LINE_BREAK) {

            for (i in LINE_BREAK downTo 0) {

                //Find the last space in the line segment and append to buffer
                if (sentence[i] == ' ') {
                    buffer.append(sentence.substring(0, i))
                    buffer.append("\n")
                    sentence = sentence.substring(i + 1, sentence.length)
                    break
                }
                if (i == 0) {
                    return "Word size more than $LINE_BREAK detected"
                }
            }
        }

        //Add any remaining words that makes a string of length less than LINE_BREAK characters
        buffer.append(sentence.substring(0, sentence.length))

        return buffer.toString().trim()
    }


    fun wrapWithSpaceSearchAndPointer(data: String?): String {

        data ?: return "Null String"

        val sentence = data.replace("\\s+".toRegex(), " ")

        //Big buffer to hold the entire paragraph
        val buffer = StringBuilder(data.length + (data.length / LINE_BREAK))

        var pointer = 0

        while (pointer < sentence.length) {

            try {
                for (i in LINE_BREAK downTo 0) {

                    //Find the last space in the line segment and append to buffer
                    if (sentence[pointer + i] == ' ') {
                        buffer.append(sentence.substring(pointer, pointer + i))
                        buffer.append("\n")
                        pointer += i + 1
                        break
                    }
                    if (i == 0) {
                        return "Word size more than $LINE_BREAK detected"
                    }
                }
            } catch (e: Exception) {
                break
            }
        }

        //Add any remaining words that makes a string of length less than LINE_BREAK characters
        buffer.append(sentence.substring(pointer, sentence.length))

        return buffer.toString().trim()
    }
}