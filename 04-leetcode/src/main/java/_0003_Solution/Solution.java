package _0003_Solution;

import java.security.KeyStore;
import java.util.HashSet;
import java.util.Set;

/**
 * @author YeYaqiao
 * 3. 无重复字符的最长子串
 */
public class Solution {
    //利用hashset
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0 || s.length() == 1)
            return s.length();
        int length = 0;
        Set<Character> set = new HashSet<>();
        int left = 0, right = 0;
        while (right < s.length()) {
            if (!set.contains(s.charAt(right)))
                set.add(s.charAt(right++));
            else
                set.remove(s.charAt(left++));
            length = Math.max(length, right - left);
        }
        return length;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.lengthOfLongestSubstring("qwweqw");
    }
}
