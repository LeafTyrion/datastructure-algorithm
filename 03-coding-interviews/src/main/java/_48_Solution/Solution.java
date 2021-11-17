package _48_Solution;

import java.util.HashMap;
import java.util.Map;

/**
 * @author YeYaqiao
 * 剑指 Offer 48. 最长不含重复字符的子字符串
 */
public class Solution {

    //动态规划 + 哈希表
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> dic = new HashMap<>();
        int res = 0, tmp = 0;
        for (int j = 0; j < s.length(); j++) {
            int i = dic.getOrDefault(s.charAt(j), -1); // 获取索引 i
            dic.put(s.charAt(j), j); // 更新哈希表
            tmp = tmp < j - i ? tmp + 1 : j - i; // dp[j - 1] -> dp[j]
            res = Math.max(res, tmp); // max(dp[j - 1], dp[j])
        }
        return res;
    }

    //动态规划 + 线性遍历
//    public int lengthOfLongestSubstring(String s) {
//        Map<Character, Integer> dic = new HashMap<>();
//        int res = 0, tmp = 0;
//        for (int j = 0; j < s.length(); j++) {
//            int i = j - 1;
//            while (i >= 0 && s.charAt(i) != s.charAt(j)) i--; // 线性查找 i
//            tmp = tmp < j - i ? tmp + 1 : j - i; // dp[j - 1] -> dp[j]
//            res = Math.max(res, tmp); // max(dp[j - 1], dp[j])
//        }
//        return res;
//    }

    //双指针 + 哈希表
//    public int lengthOfLongestSubstring(String s) {
//        Map<Character, Integer> dic = new HashMap<>();
//        int i = -1, res = 0;
//        for (int j = 0; j < s.length(); j++) {
//            if (dic.containsKey(s.charAt(j)))
//                i = Math.max(i, dic.get(s.charAt(j))); // 更新左指针 i
//            dic.put(s.charAt(j), j); // 哈希表记录
//            res = Math.max(res, j - i); // 更新结果
//        }
//        return res;
//    }
}
