package _0208_Solution;

/**
 * @author YeYaqiao
 * 208. 实现 Trie (前缀树)
 */
//public class Solution {
//
//    public static void main(String[] args) {
//        Trie trie = new Trie();
//        trie.insert("ab");
//        trie.search("abc");
//        trie.search("ab");
//        trie.startsWith("abc");
//        trie.startsWith("ab");
//        trie.insert("ab");
//        trie.search("abc");
//        trie.startsWith("abc");
//        trie.insert("abc");
//        trie.search("abc");
//        trie.startsWith("abc");
//    }
//}
//
class Trie {

    class TireNode {
        private boolean isEnd;
        TireNode[] next;

        public TireNode() {
            isEnd = false;
            next = new TireNode[26];
        }
    }

    private TireNode root;

    public Trie() {
        root = new TireNode();
    }

    public void insert(String word) {
        TireNode node = root;
        for (char c : word.toCharArray()) {
            if (node.next[c - 'a'] == null)
                node.next[c - 'a'] = new TireNode();
            node = node.next[c - 'a'];
        }
        node.isEnd = true;
    }

    public boolean search(String word) {
        TireNode node = root;
        for (char c : word.toCharArray()) {
            node = node.next[c - 'a'];
            if (node == null)
                return false;
        }
        return node.isEnd;
    }

    public boolean startsWith(String prefix) {
        TireNode node = root;
        for (char c : prefix.toCharArray()) {
            node = node.next[c - 'a'];
            if (node == null)
                return false;
        }
        return true;
    }

}


//class Trie {
//
//    private Trie[] children;
//    private boolean isEnd;
//
//    public Trie() {
//        children = new Trie[26];
//        isEnd = false;
//    }
//
//    public void insert(String word) {
//        Trie node = this;
//        for (int i = 0; i < word.length(); i++) {
//            char c = word.charAt(i);
//            int index = c - 'a';
//            if (node.children[index] == null)
//                node.children[index] = new Trie();
//            node = node.children[index];
//        }
//        node.isEnd = true;
//    }

//    public boolean search(String word) {
//
//    }
//
//    public boolean startsWith(String prefix) {
//
//    }

//}
//class Trie {
//    HashSet<String> trie = new HashSet<>();
//
//    public Trie() {
//    }
//
//    public void insert(String word) {
//        trie.add(word);
//    }
//
//    public boolean search(String word) {
//        return trie.contains(word);
//    }
//
//    public boolean startsWith(String prefix) {
//
//        for (String s : trie) {
//            if (prefix.length() > s.length())
//                continue;
//            String substring = s.substring(0, prefix.length());
//            if (substring.equals(prefix))
//                return true;
//        }
//        return false;
//    }
//}

