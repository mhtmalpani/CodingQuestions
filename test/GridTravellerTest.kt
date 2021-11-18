import org.junit.Assert

import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class GridTravellerTest
constructor(
    private val n: Int,
    private val m: Int,
    private val expectedOutput: Long
) {

    private lateinit var gridTraveller: GridTraveller

    @Before
    fun setUp() {
        gridTraveller = GridTraveller()
    }

    @Test
    fun `Test Data`() {
        val result = gridTraveller.getNumberOfWaysToTravel(n, m)

        Assert.assertEquals(expectedOutput, result)
    }

    companion object {
        @JvmStatic
        @Parameterized.Parameters
        fun data() = listOf<Array<Any?>>(
            arrayOf(1, 1, 1),
            arrayOf(1, 2, 1),
            arrayOf(2, 1, 1),
            arrayOf(2, 2, 2),
            arrayOf(2, 3, 3),
            arrayOf(3, 2, 3),
            arrayOf(3, 3, 6),
            arrayOf(3, 4, 10),
            arrayOf(4, 3, 10),
            arrayOf(4, 4, 20),
            arrayOf(18, 18, 2333606220),
        )
    }
}