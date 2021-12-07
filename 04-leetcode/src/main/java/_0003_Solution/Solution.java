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
        int left = 0, right = 0, length = 0;
        Set<Character> set = new HashSet<>();
        while (right < s.length()) {
            if (set.contains(s.charAt(right))) {
                set.remove(s.charAt(left));
                left++;
            } else {
                set.add(s.charAt(right));
                right++;
            }
            //right已经执行了++，所以计算长度时不需要+1
            length = Math.max(length, right - left);
        }
        return length;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.lengthOfLongestSubstring("qwweqw");
    }
}
