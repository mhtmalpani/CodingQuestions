class Fibonacci {

    fun get(index: Int): Long {
        return fibonacciNumber(index)
    }

    // 1, 1, 2, 3, 5, 8
    //Index starts from 1
    private fun fibonacciNumber(n: Int): Long {
        if (n <= 2)
            return 1
        return fibonacciNumber(n - 1) + fibonacciNumber(n - 2)
    }
}