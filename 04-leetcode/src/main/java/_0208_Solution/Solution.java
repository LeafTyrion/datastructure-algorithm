package _0208_Solution;

import java.util.HashSet;

/**
 * @author YeYaqiao
 * 208. 实现 Trie (前缀树)
 */
public class Solution {


    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("ab");
        trie.search("abc");
        trie.search("ab");
        trie.startsWith("abc");
        trie.startsWith("ab");
        trie.insert("ab");
        trie.search("abc");
        trie.startsWith("abc");
        trie.insert("abc");
        trie.search("abc");
        trie.startsWith("abc");
    }
}

class Trie {
    HashSet<String> trie = new HashSet<>();

    public Trie() {
    }

    public void insert(String word) {
        trie.add(word);
    }

    public boolean search(String word) {
        return trie.contains(word);
    }

    public boolean startsWith(String prefix) {

        for (String s : trie) {
            if (prefix.length() > s.length())
                continue;
            String substring = s.substring(0, prefix.length());
            if (substring.equals(prefix))
                return true;
        }
        return false;
    }
}

