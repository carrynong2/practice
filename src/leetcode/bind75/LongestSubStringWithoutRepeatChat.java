package leetcode.bind75;

public class LongestSubStringWithoutRepeatChat {
    static void main() {
        String s = "abcabcbb";
        int result = lengthOfLongestSubstring(s);
        System.out.println(result);
    }
    public static int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int maxLength = 0;
        for (int i = 0; i < n; i++) {
            boolean[] seen = new boolean[128];
            int currentLength = 0;
            for (int j = i; j < n; j++) {
                char c = s.charAt(j);
                if (seen[c]) {
                    break;
                }
                seen[c] = true;
                currentLength++;
            }
            maxLength = Math.max(maxLength, currentLength);
        }
        return maxLength;
    }
}
