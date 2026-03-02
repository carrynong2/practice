package dsa;

import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

public class EasyDpExample {
    static void main() {
        Instant start = Instant.now();
        bottomUpExample(50);
        Instant end = Instant.now();
        System.out.println("Time taken: " +
                (end.toEpochMilli() - start.toEpochMilli()) + " ms");
    }

    private static void recursiveExample(int n) {
        var fibonacciResult = fibonacci(n);
        System.out.println("Fibonacci of " + n + " is: " + fibonacciResult);
    }

    private static void recursiveExampleTopdown(int n) {
        Map<Integer, Long> memo = new HashMap<>();
        var fibonacciResult = fibonacci(n, memo);
        System.out.println("Fibonacci of " + n + " is: " + fibonacciResult);
    }

    private static void bottomUpExample(int n) {
        long[] dp = new long[n + 1];
        dp[1] = 1;
        for (int state = 2; state <= n; state++) {
            dp[state] = dp[state - 1] + dp[state - 2];
        }
        System.out.println("Fibonacci of " + n + " is: " + dp[n]);
    }

    private static int fibonacci(int n) {
        if (n <= 1) {
            return n;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    private static long fibonacci(int n, Map<Integer, Long> memo) {
        // Base case
        if (memo.containsKey(n)) {
            return memo.get(n);
        }
        if (n <= 1) {
            return n;
        }
        var result = fibonacci(n - 1, memo) + fibonacci(n - 2, memo);
        memo.put(n, result);
        return memo.get(n);
    }

}
