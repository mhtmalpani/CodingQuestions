import org.junit.Before
import org.junit.Test
import kotlin.test.assertEquals

class StaircaseTest {

    private lateinit var staircase: Staircase

    private val stepHops = listOf(1, 3, 5)

    @Before
    fun setUp() {
        staircase = Staircase()
    }

    ////////////////////////////////////////////////////////////////////////////////
    // Recursive
    ////////////////////////////////////////////////////////////////////////////////

    @Test
    fun `Staircase - Recursive - 0`() {
        val ways = staircase.numberOfWaysToClimbRecursive(0)

        assertEquals(1, ways)
    }

    @Test
    fun `Staircase - Recursive - 1`() {
        val ways = staircase.numberOfWaysToClimbRecursive(1)

        assertEquals(1, ways)
    }

    @Test
    fun `Staircase - Recursive - 2`() {
        val ways = staircase.numberOfWaysToClimbRecursive(2)

        assertEquals(2, ways)
    }

    @Test
    fun `Staircase - Recursive - 3`() {
        val ways = staircase.numberOfWaysToClimbRecursive(3)

        assertEquals(3, ways)
    }

    @Test
    fun `Staircase - Recursive - 4`() {
        val ways = staircase.numberOfWaysToClimbRecursive(4)

        assertEquals(5, ways)
    }

    @Test
    fun `Staircase - Recursive - 5`() {
        val ways = staircase.numberOfWaysToClimbRecursive(5)

        assertEquals(8, ways)
    }


    ////////////////////////////////////////////////////////////////////////////////
    // Dynamics Programming
    ////////////////////////////////////////////////////////////////////////////////

    @Test
    fun `Staircase - DP - 0`() {
        val ways = staircase.numberOfWaysToClimb(0)

        assertEquals(1, ways)
    }

    @Test
    fun `Staircase - DP - 1`() {
        val ways = staircase.numberOfWaysToClimb(1)

        assertEquals(1, ways)
    }

    @Test
    fun `Staircase - DP - 2`() {
        val ways = staircase.numberOfWaysToClimb(2)

        assertEquals(2, ways)
    }

    @Test
    fun `Staircase - DP - 3`() {
        val ways = staircase.numberOfWaysToClimb(3)

        assertEquals(3, ways)
    }

    @Test
    fun `Staircase - DP - 4`() {
        val ways = staircase.numberOfWaysToClimb(4)

        assertEquals(5, ways)
    }

    @Test
    fun `Staircase - DP - 5`() {
        val ways = staircase.numberOfWaysToClimb(5)

        assertEquals(8, ways)
    }


    ////////////////////////////////////////////////////////////////////////////////
    // Dynamics Programming - Step Hops
    ////////////////////////////////////////////////////////////////////////////////

    @Test
    fun `Staircase - DynamicSteps - 0`() {
        val ways = staircase.numberOfWaysToClimb(0, stepHops)

        assertEquals(1, ways)
    }

    @Test
    fun `Staircase - DynamicSteps - 1`() {
        val ways = staircase.numberOfWaysToClimb(1, stepHops)

        assertEquals(1, ways)
    }

    @Test
    fun `Staircase - DynamicSteps - 2`() {
        val ways = staircase.numberOfWaysToClimb(2, stepHops)

        assertEquals(1, ways)
    }

    @Test
    fun `Staircase - DynamicSteps - 3`() {
        val ways = staircase.numberOfWaysToClimb(3, stepHops)

        assertEquals(2, ways)
    }

    @Test
    fun `Staircase - DynamicSteps - 4`() {
        val ways = staircase.numberOfWaysToClimb(4, stepHops)

        assertEquals(3, ways)
    }

    @Test
    fun `Staircase - DynamicSteps - 5`() {
        val ways = staircase.numberOfWaysToClimb(5, stepHops)

        assertEquals(5, ways)
    }

    @Test
    fun `Staircase - DynamicSteps - 10`() {
        val ways = staircase.numberOfWaysToClimb(10, stepHops)

        assertEquals(47, ways)
    }

    @Test
    fun `Staircase - DynamicSteps - 20`() {
        val ways = staircase.numberOfWaysToClimb(20, stepHops)

        assertEquals(4285, ways)
    }
}