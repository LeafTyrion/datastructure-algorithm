package _0070_Solution;

/**
 * @author YeYaqiao
 * 70. 爬楼梯
 */
public class Solution {


    //    f(n)=f(n-1)+f(n-2)
    public int climbStairs(int n) {
        if (n == 1 || n == 2)
            return n;
        int sum = 0;
        int a = 1, b = 2;
        for (int i = 3; i < n; i++) {
            sum = a + b;
            a = b;
            b = sum;
        }
        return sum;
    }

    //最后一步有两种跳法，跳一阶或者跳两阶
    //递归会超时
//    public int climbStairs(int n) {
//        if (n == 1)
//            return 1;
//        if (n == 2)
//            return 2;
//        return climbStairs(n - 1) + climbStairs(n - 2);
//    }
}
