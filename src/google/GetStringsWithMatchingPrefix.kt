package google

data class Trie(
    val children: HashMap<Char, Trie> = hashMapOf(),
    var isEndOFWord: Boolean = false
)

class GetStringsWithMatchingPrefix {

    private val root = Trie()

    private val listOfWordsWithGivenPrefix = mutableListOf<String>()

    fun getStrings(dictionary: List<String>, prefix: String): List<String> {

        constructTrieDataStructure(dictionary)

        return findWordsWithPrefix(prefix)
    }

    private fun constructTrieDataStructure(dictionary: List<String>) {
        dictionary.forEach { word ->
            insertIntoTrie(word.toCharArray())
        }
    }

    private fun insertIntoTrie(chars: CharArray) {

        var current: Trie = root

        chars.forEach {

            if (!current.children.containsKey(it).orFalse()) {
                current.children[it] = Trie()
            }
            current.children[it]?.let { child ->
                current = child
            }
        }

        current.isEndOFWord = true
    }

    private fun findWordsWithPrefix(prefix: String): List<String> {

        val nodeTillPrefix = getNodeTillPrefix(prefix)

        nodeTillPrefix?.let {
            wordBuilder(nodeTillPrefix, prefix)
        }

        return listOfWordsWithGivenPrefix
    }

    private fun wordBuilder(node: Trie, construction: String) {

        if (node.isEndOFWord) {
            listOfWordsWithGivenPrefix.add(construction)
            return
        }

        node.children.forEach {
            wordBuilder(it.value, "$construction${it.key}")
        }

    }

    private fun getNodeTillPrefix(prefix: String): Trie? {
        var current = root

        prefix.toCharArray().forEach {
            if (current.children.containsKey(it).orFalse()) {
                current = current.children.getValue(it)
            } else {
                return null
            }
        }

        return current
    }

}

fun Boolean?.orFalse() = this ?: false

fun main() {

    val getStringsWithMatchingPrefix = GetStringsWithMatchingPrefix()

    val dictionary = listOf<String>(
        "deer", "dean", "dog", "dagger",
        "amazon", "apricot", "amazing", "apple", "amazed"
    )

    val words = getStringsWithMatchingPrefix.getStrings(dictionary, "de")

    words.forEach {
        println(it)
    }
}