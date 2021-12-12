package _0005_Solution;

/**
 * @author YeYaqiao
 */
public class Solution {

    //中心扩展算法
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) {
            return "";
        }
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    public int expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            --left;
            ++right;
        }
        return right - left - 1;
    }

    //暴力法
    //遍历获取所有的子串
//    public String longestPalindrome(String s) {
//        String result = "";
//        int length = 0;
//        for (int i = 0; i < s.length(); i++) {
//            for (int j = i; j <= s.length(); j++) {
//                String sub = s.substring(i, j);
//                if (sub.length() > length && isPalindrome(sub)) {
//                    length = sub.length();
//                    result = sub;
//                }
//            }
//        }
//        return result;
//    }
//
//    //判断当前字符串的所有子串是否是回文
//    private boolean isPalindrome(String s) {
//        for (int i = 0; i < s.length() / 2; i++) {
//            if (s.charAt(i) != s.charAt(s.length() - 1 - i))
//                return false;
//        }
//        return true;
//    }
}
