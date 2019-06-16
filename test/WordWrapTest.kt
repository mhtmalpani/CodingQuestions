import org.junit.Before
import org.junit.Test
import kotlin.test.assertEquals

class WordWrapTest {

    class WordWrapTestHelper {
        private val wordWrap = WordWrap()

        fun execute(data: String?): String {
            return wordWrap.wrapWithSpaceSearchAndPointer(data)
        }
    }

    private lateinit var wordWrapTestHelper: WordWrapTestHelper

    @Before
    fun setUp() {
        wordWrapTestHelper = WordWrapTestHelper()
    }

    @Test
    fun `Null String`() {

        val data = null

        val output = wordWrapTestHelper.execute(data)

        assertEquals("Null String", output)
    }

    @Test
    fun `Empty String`() {

        val data = ""

        val output = wordWrapTestHelper.execute(data)

        assertEquals("", output)
    }

    @Test
    fun `Single Character String`() {

        val data = "c"

        val output = wordWrapTestHelper.execute(data)

        assertEquals("c", output)
    }

    @Test
    fun `Single Line String`() {

        val data = "Lorem Ipsum is simply dummy text of the printing and typesetting industry."

        val output = wordWrapTestHelper.execute(data)

        assertEquals("Lorem Ipsum is simply dummy text of the printing and typesetting industry.", output)
    }

    @Test
    fun `Multiple Lines String`() {

        val data = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book."

        val output = wordWrapTestHelper.execute(data)

        assertEquals("Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem\nIpsum has been the industry's standard dummy text ever since the 1500s, when an\nunknown printer took a galley of type and scrambled it to make a type specimen\nbook.", output)
    }

    @Test
    fun `String with a word greater than LINE_BREAK`() {

        val data = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, whenanunknownprintertookagalleyoftypeandscrambledittomakeatypespecimenbookandaspecimensamplewhite paper . This type of work is usually seen in big enterprises"

        val output = wordWrapTestHelper.execute(data)

        assertEquals("Word size more than 80 detected", output)
    }

    @Test
    fun `String with multiple spaces`() {

        val data = "Lorem Ipsum is      simply dummy text of the printing and              typesetting industry. Lorem Ipsum has been the industry's standard dummy         text ever since the 1500s, when an unknown printer        took a galley of type and scrambled it to              make a type specimen book."

        val output = wordWrapTestHelper.execute(data)

        assertEquals("Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem\nIpsum has been the industry's standard dummy text ever since the 1500s, when an\nunknown printer took a galley of type and scrambled it to make a type specimen\nbook.", output)
    }

    @Test
    fun `String with trailing white spaces`() {

        val data = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book.         "

        val output = wordWrapTestHelper.execute(data)

        assertEquals("Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem\nIpsum has been the industry's standard dummy text ever since the 1500s, when an\nunknown printer took a galley of type and scrambled it to make a type specimen\nbook.", output)
    }
}