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
        char[] chars = s.toCharArray();
        Set<Character> set = new HashSet<>();
        int result = 0;
        int left = 0;
        set.add(chars[left]);
        for (int right = 0; right < chars.length; right++) {
            if (set.contains(chars[right])) {
                set.remove(chars[left]);
                left++;
            }
            set.add(chars[right]);
            result = Math.max(result, right - left + 1);
        }
        return result;
    }
}
