package _0005_Solution;

/**
 * @author YeYaqiao
 * 5. 最长回文子串
 */
public class Solution {

    //动态规划
    //对于一个回文字符串，在两端各去掉一个字符后，他依然是回文字符串
    //使用二位数组dp[i][j]，i表示数组头索引，j表示尾部索引，
    public String longestPalindrome(String s) {
        //若只有一个字符，则直接返回
        if (s.length() < 2)
            return s;

        //用于记录头尾索引之间的字符串是否是回文
        boolean[][] dp = new boolean[s.length()][s.length()];
        //所有单个的字符本身就是回文字符串
        for (int i = 0; i < s.length(); i++) {
            dp[i][i] = true;
        }
        //回文字符串长度至少是1
        int maxLength = 1;
        int leftIndex = 0;
        //枚举所有子字符串长度以及其对应得字串，从长度2开始
        for (int length = 2; length <= s.length(); length++) {
            //从左边界开始枚举，左边界的最大值为字符串的长度减去子串的长度+1
            for (int left = 0; left <= s.length() - length; left++) {
                //已知左边界，以及字符串长度length，可以确定右边界
                int right = left + length - 1;
                if (s.charAt(left) != s.charAt(right))
                    //若左右边界不相等，则在dp中记录false
                    dp[left][right] = false;
                else {
                    //若左右边界相等，还需分为两种情况考虑
                    if (right - left < 3)
                        //若此时子串长度为3，且两边相等，则必定是回文字符串
                        dp[left][right] = true;
                    else
                        //若子串长度大于3且两边相等，则可以通过dp记录的以前的结果判断子串是否是回文
                        dp[left][right] = dp[left + 1][right - 1];
                }

                if (dp[left][right] && right - left + 1 > maxLength) {
                    leftIndex = left;
                    maxLength = right - left + 1;
                }
            }
        }
        return s.substring(leftIndex, leftIndex + maxLength);
    }

    //中心扩展算法
    //回文字符串中间位置的左边的字符和右边的字符肯定相同
//    public String longestPalindrome(String s) {
//        if (s == null || s.length() < 1)
//            return "";
//        int left = 0, right = 0;
//        //以每个字符或者后面的间隔为中心
//        for (int i = 0; i < s.length(); i++) {
//            int oddLength = expandAroundOddCenter(s, i);
//            int evenLength = expandAroundEvenCenter(s, i);
//            int length = Math.max(oddLength, evenLength);
//            if (length > right - left + 1) {
//                left = i - (length - 1) / 2;
//                right = i + length / 2;
//            }
//        }
//        return s.substring(left, right + 1);
//    }
//
//    //获取以当前为中心最长的回文字符串的长度
//    //有两种情况
//    //当最长回文串是奇数时，中间位置为字符
//    private int expandAroundOddCenter(String s, int index) {
//        int right = index + 1;
//        int left = index - 1;
//        while (right <= s.length() - 1 && left >= 0 && s.charAt(right) == s.charAt(left)) {
//            left--;
//            right++;
//        }
//        return right - left - 1;
//    }
//
//    //当最长回文串为偶数时，中间位置为最中间两个字符
//    private int expandAroundEvenCenter(String s, int index) {
//        int right = index + 1;
//        int left = index;
//        while (right <= s.length() - 1 && left >= 0 && s.charAt(right) == s.charAt(left)) {
//            left--;
//            right++;
//        }
//        return right - left - 1;
//    }


//        if (s == null || s.length() < 1) {
//            return "";
//        }
//        int start = 0, end = 0;
//        for (int i = 0; i < s.length(); i++) {
//            int len1 = expandAroundCenter(s, i, i);
//            int len2 = expandAroundCenter(s, i, i + 1);
//            int len = Math.max(len1, len2);
//            if (len > end - start) {
//                start = i - (len - 1) / 2;
//                end = i + len / 2;
//            }
//        }
//        return s.substring(start, end + 1);
//    }
//
//    public int expandAroundCenter(String s, int left, int right) {
//        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
//            --left;
//            ++right;
//        }
//        return right - left - 1;
//    }

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
