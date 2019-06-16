import org.junit.Before
import org.junit.Test
import kotlin.test.assertEquals

class DecodingWaysTest {

    class DecodingWaysTestHelper {

        private val decodingWays = DecodingWays()

        fun execute(string: String): Int {
            return decodingWays.numberOfWaysDynamicApproach(string)
        }
    }

    private lateinit var subject: DecodingWaysTestHelper

    @Before
    fun setUp() {
        subject = DecodingWaysTestHelper()
    }

    @Test
    fun `Empty Test`() {
        val result = subject.execute("")

        assertEquals(1, result)
    }

    @Test
    fun `Zero Test`() {
        val result = subject.execute("00111")

        assertEquals(0, result)
    }

    @Test
    fun `Basic Test - 1`() {
        val result = subject.execute("111")

        assertEquals(3, result)
    }

    @Test
    fun `Basic Test - 2`() {
        val result = subject.execute("3412312423546712112120")

        assertEquals(234, result)
    }

    @Test
    fun `Basic Test - 3`() {
        val result = subject.execute("2454254657546546676757565343434543432311343567786568")

        assertEquals(24, result)
    }

    @Test
    fun `Basic Test - 4`() {
        val result = subject.execute("345346790008786756578907645324345767")

        assertEquals(0, result)
    }

    @Test
    fun `Basic Test - 5`() {
        val result = subject.execute("134345678075679076534357805454234")

        assertEquals(0, result)
    }

    @Test
    fun `Basic Test - 6`() {
        val result = subject.execute("121345231212124353123145122211154563511111")

        assertEquals(342720, result)
    }
}