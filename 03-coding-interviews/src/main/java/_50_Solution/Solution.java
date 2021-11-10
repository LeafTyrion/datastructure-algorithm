package _50_Solution;

import java.util.HashMap;
import java.util.Map;

/**
 * @author YeYaqiao
 * 剑指 Offer 50. 第一个只出现一次的字符
 */
public class Solution {

    //暴力法
    public char firstUniqChar(String s) {
        Map<Character, Boolean> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            Character character = s.charAt(i);
            map.put(character, map.containsKey(character));
        }
        for (int i = 0; i < s.length(); i++) {
            if (map.get(s.charAt(i)) == false)
                return s.charAt(i);
        }
        return ' ';
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.firstUniqChar("leetcode"));
    }
}
