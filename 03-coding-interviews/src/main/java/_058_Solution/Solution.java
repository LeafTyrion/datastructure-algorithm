package _058_Solution;

/**
 * @author YeYaqiao
 * 剑指 Offer 58 - II. 左旋转字符串
 */
public class Solution {

    //求余，遍历
//    public String reverseLeftWords(String s, int n) {
//        StringBuilder result = new StringBuilder();
//        for (int i = n; i < s.length() + n; i++) {
//            result.append(s.charAt(i % s.length()));
//        }
//        return String.valueOf(result);
//    }

    //利用 subString() API
//    public String reverseLeftWords(String s, int n) {
//        return s.substring(n) + s.substring(0, n);
//    }
}