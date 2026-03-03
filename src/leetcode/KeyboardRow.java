package leetcode;

import java.util.Arrays;
import java.util.Objects;

public class KeyboardRow {
    static void main() {
        String[] words = {"Hello", "Alaska", "Dad", "Peace"};
        System.out.println(Arrays.toString(findWords(words)));
    }
    public static String[] findWords(String[] words) {
        String row1 = "qwertyuiop";
        String row2 = "asdfghjkl";
        String row3 = "zxcvbnm";
        String[] result = new String[words.length];
        int index = 0;
        for (String word : words) {
            String lowerCaseWord = word.toLowerCase();
            if (isInRow(lowerCaseWord, row1) || isInRow(lowerCaseWord, row2) || isInRow(lowerCaseWord, row3)) {
                result[index++] = word;
            }
        }
        return Arrays.stream(result).filter(Objects::nonNull).toArray(String[]::new);
    }

    private static boolean isInRow(String lowerCaseWord, String row1) {
        return lowerCaseWord.chars().allMatch(c -> row1.indexOf(c) != -1);
    }
}
