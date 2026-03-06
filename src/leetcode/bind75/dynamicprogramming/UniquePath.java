package leetcode.bind75.dynamicprogramming;

import java.util.HashMap;
import java.util.Map;

public class UniquePath {
    static void main() {
        int m = 3, n = 7;
        Map<String, Integer> memo = new HashMap<>();
        System.out.println(uniquePaths(m, n, memo));
    }
    public static int uniquePaths(int m, int n, Map<String, Integer> memo) {
        String key = m + "," + n;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }
        if (m == 1 && n == 1) {
            return 1;
        }
        if (m == 0 || n == 0) {
            return 0;
        }
        int res = uniquePaths(m - 1, n, memo) + uniquePaths(m, n - 1, memo);
        memo.put(key, res);
        return res;
    }
}
