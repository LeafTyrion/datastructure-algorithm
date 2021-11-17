package _46_Solution;

/**
 * @author YeYaqiao
 * 剑指 Offer 46. 把数字翻译成字符串
 */
public class Solution {

    //数字求余，动态规划
    public int translateNum(int num) {
        String s = String.valueOf(num);
        int a = 1, b = 1, x, y = num % 10;
        while (num != 0) {
            num /= 10;
            x = num % 10;
            int tmp = 10 * x + y;
            int c = (tmp >= 10 && tmp <= 25) ? a + b : a;
            b = a;
            a = c;
            y = x;
        }
        return a;
    }

    //字符串遍历，动态规划
//    public int translateNum(int num) {
//        String s = String.valueOf(num);
//        int a = 1, b = 1;
//        for (int i = 2; i <= s.length(); i++) {
//            String temp = s.substring(i - 2, i);
//            int c = temp.compareTo("10") >= 0 && temp.compareTo("25") <= 0 ? a + b : a;
//            b = a;
//            a = c;
//        }
//        return a;
//    }
}
