package leetcode;

public class LengthOfLastWord {
    static void main() {
        String s = "Hello World";
        System.out.println(lengthOfLastWord(s));
    }
    public static int lengthOfLastWord(String s) {
        String[] chars = s.split(" ");
        return chars[chars.length - 1].length();
    }
}
