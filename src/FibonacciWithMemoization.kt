class FibonacciWithMemoization {

    private val memo = HashMap<Int, Long>()

    fun get(index: Int): Long {
        return fibonacciNumber(index)
    }

    private fun fibonacciNumber(n: Int): Long {
        //Return early from Memo
        if (memo.contains(n))
            return memo.getValue(n)

        //Base case
        if (n <= 2)
            return 1

        //Write to memo
        memo[n] = fibonacciNumber(n - 1) + fibonacciNumber(n - 2)

        //Base return value
        return memo.getValue(n)
    }
}