package _64_Solution;

/**
 * @author YeYaqiao
 * 剑指 Offer 64. 求1+2+…+n
 */
public class Solution {
    public int sumNums(int n) {
        //通过 && 控制结束递归
        boolean x = n > 1 && (n += sumNums(n - 1)) > 0;
        return n;
    }
}
