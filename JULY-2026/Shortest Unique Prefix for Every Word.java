// Shortest Unique Prefix for Every Word

class Solution {
    // Define the Trie Node class
    static class TrieNode {
        Map<Character, TrieNode> children = new HashMap<>();
        int frequency = 0;
    }

    // Root of the Trie
    private TrieNode root;

    // Method to insert a word into the Trie
    private void insert(String word) {
        TrieNode current = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            // If the character node doesn't exist, create a new one
            current.children.putIfAbsent(ch, new TrieNode());
            current = current.children.get(ch);
            // Increment the frequency of this node
            current.frequency++;
        }
    }

    // Method to find the shortest unique prefix for a word
    private String findUniquePrefix(String word) {
        TrieNode current = root;
        StringBuilder prefix = new StringBuilder();

        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            prefix.append(ch);
            current = current.children.get(ch);

            // If this node is visited only once, it's unique to this word
            if (current.frequency == 1) {
                return prefix.toString();
            }
        }
        return prefix.toString();
    }

    public ArrayList<String> findPrefixes(ArrayList<String> arr) {
        root = new TrieNode();
        ArrayList<String> result = new ArrayList<>();

        // Step 1: Insert all words into the Trie
        for (String word : arr) {
            insert(word);
        }

        // Step 2: Find the unique prefix for each word in order
        for (String word : arr) {
            result.add(findUniquePrefix(word));
        }

        return result;
    }
}