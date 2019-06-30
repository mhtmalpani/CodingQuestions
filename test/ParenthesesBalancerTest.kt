import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class ParenthesesBalancerTest {

    private lateinit var parenthesesBalancer: ParenthesesBalancer

    @Before
    fun setUp() {
        parenthesesBalancer = ParenthesesBalancer()
    }

    @Test
    fun `Empty Test`() {
        val data = ""

        val result = parenthesesBalancer.isBalanced(data)

        assertEquals(true, result)
    }

    @Test
    fun `Single Value Test - 1`() {
        val data = "["

        val result = parenthesesBalancer.isBalanced(data)

        assertEquals(false, result)
    }

    @Test
    fun `Single Value Test - 2`() {
        val data = ")"

        val result = parenthesesBalancer.isBalanced(data)

        assertEquals(false, result)
    }

    @Test
    fun `Single Bracket Test`() {
        val data = "[]"

        val result = parenthesesBalancer.isBalanced(data)

        assertEquals(true, result)
    }

    @Test
    fun `Symmetric Value Test - Balanced`() {
        val data = "[{()}]"

        val result = parenthesesBalancer.isBalanced(data)

        assertEquals(true, result)
    }

    @Test
    fun `Symmetric Value Test - Unbalanced - 1`() {
        val data = "[{()}])"

        val result = parenthesesBalancer.isBalanced(data)

        assertEquals(false, result)
    }

    @Test
    fun `Symmetric Value Test - Unbalanced - 2`() {
        val data = "[({()}]"

        val result = parenthesesBalancer.isBalanced(data)

        assertEquals(false, result)
    }

    @Test
    fun `Asymmetric Value Test - Balanced`() {
        val data = "[()]{}{[()()]()}"

        val result = parenthesesBalancer.isBalanced(data)

        assertEquals(true, result)
    }

    @Test
    fun `Asymmetric Value Test - Unbalanced - 1`() {
        val data = "[()]{}{[()()]())}"

        val result = parenthesesBalancer.isBalanced(data)

        assertEquals(false, result)
    }

    @Test
    fun `Asymmetric Value Test - Unbalanced - 2`() {
        val data = "[()]{}{{[()()]()}"

        val result = parenthesesBalancer.isBalanced(data)

        assertEquals(false, result)
    }

    @Test
    fun `Abnormal Value Test`() {
        val data = "[abc]"

        val result = parenthesesBalancer.isBalanced(data)

        assertEquals(true, result)
    }

    @Test
    fun `Custom Parenthesis Test - Balanced - 1`() {

        val customParenthesis = mapOf(Pair('x', 'y'))

        parenthesesBalancer = ParenthesesBalancer(customParenthesis)

        val data = "[xyxy]"

        val result = parenthesesBalancer.isBalanced(data)

        assertEquals(true, result)
    }

    @Test
    fun `Custom Parenthesis Test - Balanced - 2`() {

        val customParenthesis = mapOf(Pair('x', 'y'), Pair('a', 'b'))

        parenthesesBalancer = ParenthesesBalancer(customParenthesis)

        val data = "[xyaxybaabbc]"

        val result = parenthesesBalancer.isBalanced(data)

        assertEquals(true, result)
    }

    @Test
    fun `Custom Parenthesis Test - Unbalanced - 1`() {

        val customParenthesis = mapOf(Pair('x', 'y'))

        parenthesesBalancer = ParenthesesBalancer(customParenthesis)

        val data = "[xyxxy]"

        val result = parenthesesBalancer.isBalanced(data)

        assertEquals(false, result)
    }

    @Test
    fun `Custom Parenthesis Test - Unbalanced - 2`() {

        val customParenthesis = mapOf(Pair('x', 'y'), Pair('a', 'b'))

        parenthesesBalancer = ParenthesesBalancer(customParenthesis)

        val data = "[xyaxy]"

        val result = parenthesesBalancer.isBalanced(data)

        assertEquals(false, result)
    }

    @Test
    fun `Custom Parenthesis Test - Unbalanced - 3`() {

        val customParenthesis = mapOf(Pair('x', 'y'))

        parenthesesBalancer = ParenthesesBalancer(customParenthesis)

        val data = "[xy{xy]"

        val result = parenthesesBalancer.isBalanced(data)

        assertEquals(false, result)
    }

    @Test
    fun `Alphanumeric Value Test - Balanced - 1`() {
        val data = "[1+2]"

        val result = parenthesesBalancer.isBalanced(data)

        assertEquals(true, result)
    }

    @Test
    fun `Alphanumeric Value Test - Balanced - 2`() {
        val data = "[(7+2)*4]-{4*2}"

        val result = parenthesesBalancer.isBalanced(data)

        assertEquals(true, result)
    }

    @Test
    fun `Alphanumeric Value Test - Unbalanced - 1`() {
        val data = "[(7+2)*4}]-{4*2}"

        val result = parenthesesBalancer.isBalanced(data)

        assertEquals(false, result)
    }

    @Test
    fun `Alphanumeric Value Test - Unbalanced - 2`() {
        val data = "[((7+2)*4}]-{4*2}"

        val result = parenthesesBalancer.isBalanced(data)

        assertEquals(false, result)
    }

    @Test(expected = Exception::class)
    fun `Full Stack Test`() {
        val data = "[[[[[[[[[[{{}}]]]]]]]]]]"

        parenthesesBalancer.isBalanced(data)
    }
}