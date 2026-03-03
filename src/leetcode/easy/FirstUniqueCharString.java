package leetcode.easy;

public class FirstUniqueCharString {
    static void main() {
        String s = "leetcode";
        int result = firstUniqChar(s);
        System.out.println("result = " + result);
    }
    public static int firstUniqChar(String s) {
       for (int i = 0; i < s.length(); i++) {
           char c = s.charAt(i);
           if (s.indexOf(c) == s.lastIndexOf(c)) {
               return i;
           }
       }
       return -1;
    }
}
