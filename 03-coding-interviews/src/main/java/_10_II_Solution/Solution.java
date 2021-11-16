package _10_II_Solution;

/**
 * @author YeYaqiao
 * 剑指 Offer 10- II. 青蛙跳台阶问题
 */
public class Solution {
    /*
    题目分析，证明其为斐波那契数列
    台阶数：1、2、3、4······n-2、   n-1、   n
    总跳法：1、2、3、5······f(n-2)、f(n-1)、f(n)
    最后一次有两种跳法：一次跳一阶、一次跳两阶
    当只剩一阶台阶时，已经存在了 f(n-1) 种跳法
    当只剩两阶台阶时，已经存在了 f(n-2) 种跳法
    所以跳上最后一个台阶的跳法总数为 f(n)=f(n-1)+f(n-2)
    此公式为斐波那契数列的公式
     */
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

    //递归法，会超时
//    public int numWays(int n) {
//        if (n == 0)
//            return 1;
//        if (n == 1 || n == 2)
//            return n;
//        return (numWays(n - 1) + numWays(n - 2)) % 1000000007;
//    }

}
