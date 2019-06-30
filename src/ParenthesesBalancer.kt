/**
 * Problem Statement:
 *
 * Given a string of round, curly, and square open and closing brackets,
 * return whether the brackets are balanced (well-formed).
 *
 * For example, given the string "([])[]({})", should return true.
 *
 * Given the string "([)]" or "((()", should return false.
 *
 *
 * Additional:
 * How to handle an equation?
 * For example, given the string "([2+3]*5)-[6+2]", should return true.
 *
 *
 * Additional:
 * How to handle a new pair of custom Parenthesis?
 * For example, given the string "([xyxy])" and additional pair (x, y) should return true
 * For example, given the string "[xyabb]" and additional pairs (x, y) & (a, b) should return true
 *
 */

class Stack(private val MAX_CAPACITY: Int = 10) {

    private var top = -1
    private val items = CharArray(MAX_CAPACITY)

    fun push(item: Char) {

        if (top == MAX_CAPACITY - 1)
            throw Exception("Overflow")

        items[++top] = item
    }

    fun pop(): Char {

        if (top == -1)
            throw Exception("Underflow")

        return items[top--]
    }

    fun isEmpty(): Boolean {

        return top == -1
    }

}

class ParenthesesBalancer(customPairs: Map<Char, Char> = mapOf()) {

    private val pairs = mutableMapOf<Char, Char>(
            Pair('[', ']'),
            Pair('{', '}'),
            Pair('(', ')')
    )

    init {
        pairs.putAll(customPairs)
    }


    fun isBalanced(data: String): Boolean {

        val stack = Stack()

        data.forEach { char ->

            when {
                pairs.keys.contains(char) -> {
                    try {
                        stack.push(char)
                    } catch (e: Exception) {
                        throw e
                    }
                }

                pairs.values.contains(char) -> {
                    try {
                        if (!validMatch(stack.pop(), char)) {
                            return false
                        }
                    } catch (e: Exception) {
                        return false
                    }
                }
            }

        }

        return stack.isEmpty()
    }

    private fun validMatch(open: Char, close: Char): Boolean {
        return pairs[open] == close
    }

}