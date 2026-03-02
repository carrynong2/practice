package dsa;

public class FactorialExample {
    static void main() {
        iterativeExample(5);
        System.out.println();
        recursiveExample(6);
    }

    private static void recursiveExample(int n) {
        var factorialResult = factorial(n);
        System.out.println("Factorial of " + n + " is: " + factorialResult);
        var fibonacciResult = fibonacci(n);
        System.out.println("Fibonacci of " + n + " is: " + fibonacciResult);
    }

    private static int fibonacci(int n) {
        if (n <= 1) {
            return n;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    private static int factorial(int n) {
        // Base case
        if (n == 0 || n == 1) {
            return 1;
        }
        // Recursive case
        return factorial(n - 1) * n;
    }

    private static void iterativeExample(int n) {
        var result = 1;
        for (var i = 1; i <= n; i++) {
            result *= i;
        }
        System.out.println(result);
    }
}
