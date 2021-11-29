package _15_Solution;

/**
 * @author YeYaqiao
 * 剑指 Offer 15. 二进制中1的个数
 */
public class Solution {
    //利用无符号右移和&运算符
    public int hammingWeight(int n) {
        int result = 0;
        while (n != 0) {
            if ((n & 1) == 1)
                result++;
            n = n >>> 1;
        }
        return result;
    }
}
