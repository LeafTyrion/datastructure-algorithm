package _0005_Solution;

/**
 * @author YeYaqiao
 */
public class Solution {

    //动态规划
    public String longestPalindrome(String s) {

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
