package _005_Solution;

/**
 * @author YeYaqiao
 * 剑指 Offer 05. 替换空格
 */
public class Solution {

    //暴力遍历添加
    public String replaceSpace(String s) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ')
                result.append("%20");
            else
                result.append(s.charAt(i));
        }
        return String.valueOf(result);
    }

    //replace() API
//    public String replaceSpace(String s) {
//        return s.replace(" ", "%20");
//    }

}
