import java.util.HashMap;

public class Trie {
    private class TrieNode {
        HashMap<Character, TrieNode> childern;
        boolean isEnd;

        TrieNode() {
            this.childern = new HashMap<>();
        }
    }

    private TrieNode root;

    public Trie() {
        this.root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode current = this.root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            TrieNode temp = current.childern.get(ch);
            if (temp == null) {
                temp = new TrieNode();
                current.childern.put(ch, temp);
            }
            current = temp;
        }
        current.isEnd = true;
    }

    public boolean search(String word) {
        TrieNode trieNode = searchNode(word);
        return trieNode != null && trieNode.isEnd;
    }

    public boolean startsWith(String prefix) {
        return searchNode(prefix) != null;
    }

    private TrieNode searchNode(String word) {
        TrieNode current = this.root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            TrieNode temp = current.childern.get(ch);
            if (temp == null) return null;
            current = temp;
        }
        return current;
    }

    public void delete(String word) {
        delete(this.root, word, 0);
    }

    private boolean delete(TrieNode current, String word, int index) {
        if (index == word.length()) {
            if (!current.isEnd) return false;
            current.isEnd = false;
            return current.childern.size() == 0;
        }
        char ch = word.charAt(index);
        TrieNode node = current.childern.get(ch);
        if (node == null) return false;
        boolean shouldDeleteCurrentNode = delete(node, word, index + 1);
        if (shouldDeleteCurrentNode) {
            current.childern.remove(ch);
            return current.childern.size() == 0;
        }
        return false;
    }

    /* Commented code below can be used to test 'Trie'
    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("Fun");
        trie.insert("Food");
        trie.insert("Fame");
        trie.insert("Fault");
        System.out.println("Trie is " + (trie.startsWith("F") ? "" : "not ") + "having names starting with 'F'.");
        System.out.println("Trie is " + (trie.startsWith("D") ? "" : "not ") + "having names starting with 'D'.");
        System.out.println("Fun is " + (trie.search("Fun") ? "" : "not ") + "present in trie.");
        System.out.println("Food is " + (trie.search("Food") ? "" : "not ") + "present in trie.");
        System.out.println("Fame is " + (trie.search("Fame") ? "" : "not ") + "present in trie.");
        System.out.println("Fault is " + (trie.search("Fault") ? "" : "not ") + "present in trie.");
        trie.delete("Fault");
        System.out.println("Now 'Fault' is removed from trie.");
        System.out.println("Fun is " + (trie.search("Fun") ? "" : "not ") + "present in trie.");
        System.out.println("Food is " + (trie.search("Food") ? "" : "not ") + "present in trie.");
        System.out.println("Fame is " + (trie.search("Fame") ? "" : "not ") + "present in trie.");
        System.out.println("Fault is " + (trie.search("Fault") ? "" : "not ") + "present in trie.");
    }
    */
}
