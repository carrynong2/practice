package dsa;

public class TrieExample {
    static void main() {
        String[] words = {
                "apple", "banana", "grape", "orange", "watermelon",
                "kiwi", "strawberry", "blueberry", "mango", "pineapple",
                "peach", "cherry", "pear", "plum", "apricot",
                "blackberry", "raspberry", "coconut", "papaya", "fig"
        };
        var trieRoot = new Trie();
        // Insert
        for (String word : words) {
            trieRoot.insert(word);
        }
        // Search
        System.out.println("Is 'apple' in the trie? " + trieRoot.search("apple"));
    }
}
