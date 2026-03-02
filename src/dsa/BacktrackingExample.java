package dsa;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BacktrackingExample {
    static void main() {
        subset();
        System.out.println();
        phoneLetterCombination();
    }
    private static void subset() {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = List.of(1, 2, 3);
        backtrackSubset(list, 0, new LinkedList<>(), result);
        System.out.println("Subsets: " + result);
    }

    private static void backtrackSubset(List<Integer> list, int index,
                                        LinkedList<Integer> currentState,
                                        List<List<Integer>> result) {
        result.add(new ArrayList<>(currentState));
        for (int i  = index; i < list.size(); i++) {
            currentState.add(list.get(i));
            backtrackSubset(list, i + 1,  currentState, result);
            currentState.removeLast();
        }
    }

    private static void phoneLetterCombination() {
        List<String> result = new ArrayList<>();
        String digits = "23";
        backtrackLetterCombination(digits, 0, new LinkedList<>(), result);
        System.out.println("phoneLetterCombination: " + result);
    }

    private static void backtrackLetterCombination(String digits,
                                                   int index,
                                                   LinkedList<Character> currentState,
                                                   List<String> result) {
        if (index == digits.length()) {
            result.add(currentState.stream().map(String::valueOf).reduce("", String::concat));
            return;
        }
        int digit = digits.charAt(index) - '0';
        String possibleChars = getPad(digit);
        for (char c : possibleChars.toCharArray()) {
            currentState.add(c);
            backtrackLetterCombination(digits, index + 1, currentState, result);
            currentState.removeLast();
        }
    }

    private static String getPad(int d) {
        return switch (d) {
            case 2 -> "abc";
            case 3 -> "def";
            case 4 -> "ghi";
            case 5 -> "jkl";
            case 6 -> "mno";
            case 7 -> "pqrs";
            case 8 -> "tuv";
            case 9 -> "wxyz";
            default -> "";
        };
    }
}
