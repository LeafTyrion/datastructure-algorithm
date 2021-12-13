package _0005_Solution;

/**
 * @author YeYaqiao
 * 5. 最长回文子串
 */
public class Solution {

    //动态规划
    //对于一个回文字符串，在两端各去掉一个字符后，他依然是回文字符串
    public String longestPalindrome(String s) {
        int len = s.length();
        if (len < 2) {
            return s;
        }

        int maxLen = 1;
        int begin = 0;
        // dp[i][j] 表示 s[i..j] 是否是回文串
        boolean[][] dp = new boolean[len][len];
        // 初始化：所有长度为 1 的子串都是回文串
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }

        char[] charArray = s.toCharArray();
        // 递推开始
        // 先枚举子串长度
        for (int L = 2; L <= len; L++) {
            // 枚举左边界，左边界的上限设置可以宽松一些
            for (int i = 0; i < len; i++) {
                // 由 L 和 i 可以确定右边界，即 j - i + 1 = L 得
                int j = L + i - 1;
                // 如果右边界越界，就可以退出当前循环
                if (j >= len) {
                    break;
                }

                if (charArray[i] != charArray[j]) {
                    dp[i][j] = false;
                } else {
                    if (j - i < 3) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }

                // 只要 dp[i][L] == true 成立，就表示子串 s[i..L] 是回文，此时记录回文长度和起始位置
                if (dp[i][j] && j - i + 1 > maxLen) {
                    maxLen = j - i + 1;
                    begin = i;
                }
            }
        }
        return s.substring(begin, begin + maxLen);
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
