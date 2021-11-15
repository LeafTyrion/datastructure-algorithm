package _010_I_Solution;

/**
 * @author YeYaqiao
 * 剑指 Offer 10- I. 斐波那契数列
 */
public class Solution {

    //循环法
    public int fib(int n) {
        if (n == 0 || n == 1)
            return n;
        int result = 0;
        int a = 0;
        int b = 1;
        for (int i = 2; i <= n; i++) {
            result = a + b;
            a = b;
            b = result;
        }
        return result;
    }

    //矩阵，脑子已经被卷坏了
//    static final int MOD = 1000000007;
//
//    public int fib(int n) {
//        if (n < 2) {
//            return n;
//        }
//        int[][] q = {{1, 1}, {1, 0}};
//        int[][] res = pow(q, n - 1);
//        return res[0][0];
//    }
//
//    public int[][] pow(int[][] a, int n) {
//        int[][] ret = {{1, 0}, {0, 1}};
//        while (n > 0) {
//            if ((n & 1) == 1) {
//                ret = multiply(ret, a);
//            }
//            n >>= 1;
//            a = multiply(a, a);
//        }
//        return ret;
//    }
//
//    public int[][] multiply(int[][] a, int[][] b) {
//        int[][] c = new int[2][2];
//        for (int i = 0; i < 2; i++) {
//            for (int j = 0; j < 2; j++) {
//                c[i][j] = (int) (((long) a[i][0] * b[0][j] + (long) a[i][1] * b[1][j]) % MOD);
//            }
//        }
//        return c;
//    }

    //递归法，会超时
//    public int fib(int n) {
//        if (n == 0 || n == 1)
//            return n;
//        if(n==2)
//            return 1;
//        return fib(n-1)+fib(n-2);
//    }
}
