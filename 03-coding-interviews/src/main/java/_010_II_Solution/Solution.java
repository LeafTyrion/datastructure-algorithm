package _010_II_Solution;

/**
 * @author YeYaqiao
 * 剑指 Offer 10- II. 青蛙跳台阶问题
 */
public class Solution {
    public int numWays(int n) {
        if (n == 1 || n == 2)
            return n;
        int a = 1, b = 2, sum = 1;
        for (int i = 3; i <= n; i++) {
            sum = (a + b) % 1000000007;
            a = b;
            b = sum;
        }
        return sum;
    }
}
