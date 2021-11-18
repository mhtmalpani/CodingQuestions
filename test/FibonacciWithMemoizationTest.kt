import org.junit.Assert

import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class FibonacciWithMemoizationTest
constructor(
    private val index: Int,
    private val expectedOutput: Long
) {

    private lateinit var fibonacciWithMemoization: FibonacciWithMemoization

    @Before
    fun setUp() {
        fibonacciWithMemoization = FibonacciWithMemoization()
    }

    @Test
    fun `Test Data`() {
        val result = fibonacciWithMemoization.get(index)

        Assert.assertEquals(expectedOutput, result)
    }

    companion object {
        @JvmStatic
        @Parameterized.Parameters
        fun data() = listOf<Array<Any?>>(
            arrayOf(1, 1),
            arrayOf(2, 1),
            arrayOf(3, 2),
            arrayOf(4, 3),
            arrayOf(5, 5),
            arrayOf(6, 8),
            arrayOf(7, 13),
            arrayOf(8, 21),
            arrayOf(9, 34),
            arrayOf(10, 55),
            arrayOf(11, 89),

            //Additional
            arrayOf(30, 832040),
            arrayOf(50, 12586269025),
            arrayOf(60, 1548008755920),
        )
    }
}