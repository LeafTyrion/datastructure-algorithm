package _05_Solution;

/**
 * @author YeYaqiao
 * 剑指 Offer 05. 替换空格
 */
public class Solution {
    //使用 replace()
//    public String replaceSpace(String s) {
//        return s.replace(" ", "%20");
//    }

    //暴力遍历判断添加
    public String replaceSpace(String s) {

        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            if (' ' == s.charAt(i)) {
                stringBuilder.append("%20");
            } else {
                stringBuilder.append(s.charAt(i));
            }
        }

        return stringBuilder.toString();

    }


}
