package _16_Solution;

/**
 * @author YeYaqiao
 * 剑指 Offer 16. 数值的整数次方
 */
public class Solution {

    //递归，快速幂(二分法思想)
    public double myPow(double x, int n) {
        if (n == 0) return 1;
        if (n == 1) return x;
        if (n == -1) return 1 / x;
        double half = myPow(x, n / 2);
        double mod = myPow(x, n % 2);
        return half * half * mod;
    }

    //迭代，快速幂
//    public double myPow(double x, int n) {
//        if (x == 0) return 0;
//        long b = n;
//        double res = 1.0;
//        if (b < 0) {
//            x = 1 / x;
//            b = -b;
//        }
//        while (b > 0) {
//            if ((b & 1) == 1)
//                res = res * x;
//            x *= x;
//            b >>= 1;
//        }
//        return res;
//    }

    //暴力法会超时
//    public double myPow(double x, int n) {
//        if (x == 0)
//            return 0;
//        if (n == 0)
//            return 1;
//
//        double result = 1;
//        for (int i = 1; i <= Math.abs(n); i++) {
//            result = result * x;
//        }
//
//        if (n < 0)
//            result = 1 / result;
//
//        return result;
//    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.myPow(2, 2));
    }
}
