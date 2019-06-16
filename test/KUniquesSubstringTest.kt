import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class KUniquesSubstringTest {

    class KUniquesSubstringTestHelper {

        private var kUniquesSubstring = KUniquesSubstring()

        fun execute(string: String, k: Int): String {
            return kUniquesSubstring.getKUniqueSubstring(string, k)
        }
    }

    private lateinit var subject: KUniquesSubstringTestHelper

    companion object {
        private const val VALUE_1 = "aabacbebebe"
        private const val VALUE_2 = "fdkssssddsasfghjkasdfhasdfsfgfdalkjhkjhjghjk"
    }

    @Before
    fun setUp() {
        subject = KUniquesSubstringTestHelper()
    }

    @Test
    fun `Basic Test - 1`() {
        val result = subject.execute(VALUE_1, 1)

        assertEquals("aa", result)
    }

    @Test
    fun `Basic Test - 2`() {
        val result = subject.execute(VALUE_1, 2)

        assertEquals("bebebe", result)
    }

    @Test
    fun `Basic Test - 3`() {
        val result = subject.execute(VALUE_1, 3)

        assertEquals("cbebebe", result)
    }

    @Test
    fun `Basic Test - 4`() {
        val result = subject.execute(VALUE_1, 4)

        assertEquals("aabacbebebe", result)
    }

    @Test
    fun `Basic Test - 5`() {
        val result = subject.execute(VALUE_1, 5)

        assertEquals("aabacbebebe", result)
    }

    @Test
    fun `Null Test`() {
        val result = subject.execute(VALUE_1, 0)

        assertEquals("k should be greater than 0", result)
    }

    @Test
    fun `Big Test - 1`() {
        val result = subject.execute(VALUE_2, 1)

        assertEquals("ssss", result)
    }

    @Test
    fun `Big Test - 2`() {
        val result = subject.execute(VALUE_2, 2)

        assertEquals("ssssdds", result)
    }

    @Test
    fun `Big Test - 3`() {
        val result = subject.execute(VALUE_2, 3)

        assertEquals("dkssssdds", result)
    }

    @Test
    fun `Big Test - 4`() {
        val result = subject.execute(VALUE_2, 4)

        assertEquals("dkssssddsas", result)
    }

    @Test
    fun `Big Test - 5`() {
        val result = subject.execute(VALUE_2, 5)

        assertEquals("fdkssssddsasf", result)
    }

    @Test
    fun `Big Test - 6`() {
        val result = subject.execute(VALUE_2, 6)

        assertEquals("asdfhasdfsfgfda", result)
    }

    @Test
    fun `Big Test - 7`() {
        val result = subject.execute(VALUE_2, 7)

        assertEquals("kasdfhasdfsfgfda", result)
    }

    @Test
    fun `Big Test - 8`() {
        val result = subject.execute(VALUE_2, 8)

        assertEquals("fdkssssddsasfghjkasdfhasdfsfgfda", result)
    }

    @Test
    fun `Big Test - 9`() {
        val result = subject.execute(VALUE_2, 9)

        assertEquals("fdkssssddsasfghjkasdfhasdfsfgfdalkjhkjhjghjk", result)
    }
}