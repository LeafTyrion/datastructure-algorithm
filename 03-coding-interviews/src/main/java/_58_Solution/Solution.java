package _58_Solution;

/**
 * @author YeYaqiao
 * 剑指 Offer 58 - II. 左旋转字符串
 */
public class Solution {

    //暴力法 String 优化代码版
//    public String reverseLeftWords(String s, int n) {
//        String result = "";
//        int length = s.length();
//        for (int i = n; i < n + length; i++)
//            result += s.charAt(i % length);
//
//        return result;
//    }

    //暴力法 StringBuilder
//    public String reverseLeftWords(String s, int n) {
//
//        StringBuilder stringBuilder = new StringBuilder();
//
//        for (int i = n; i < s.length(); i++) {
//            stringBuilder.append(s.charAt(i));
//        }
//        for (int i = 0; i < n; i++) {
//            stringBuilder.append(s.charAt(i));
//        }
//
//        return String.valueOf(stringBuilder);
//    }

    //利用 subString()
    public String reverseLeftWords(String s, int n) {
        return s.substring(n)+s.substring(0,n);
    }


}