package _58_I_Solution;

/**
 * @author YeYaqiao
 * 剑指 Offer 58 - I. 翻转单词顺序
 */
public class Solution {

    //双指针，记录每个单词的左右边界
    public String reverseWords(String s) {
        //去除首位空格
        s = s.trim();
        //获取最后一个单词的索引
        int j = s.length() - 1, i = j;
        StringBuilder res = new StringBuilder();
        while (i >= 0) {
            //获取单纯的首个字母的索引
            while (i >= 0 && s.charAt(i) != ' ')
                i--;
            //添加这个单词到 res 中
            res.append(s, i + 1, j + 1).append(" ");
            //继续左移i指针，直到遇到第一个不为空的字符，并更新单词的尾部索引
            while (i >= 0 && s.charAt(i) == ' ')
                i--;
            j = i;
        }
        return res.toString().trim();
    }

    //利用 split() 和 trim()
//    public String reverseWords(String s) {
//        StringBuilder result = new StringBuilder();
//        //trim() 去除头尾的空格
//        String[] temp = s.trim().split(" ");
//        for (int i = temp.length - 1; i >= 0; i--) {
//            if (!"".equals(temp[i]))
//                result.append(temp[i]).append(" ");
//        }
//        return result.toString().trim();
//    }
}
