package _0338_Solution;

/**
 * @author YeYaqiao
 * 338. 比特位计数
 */
public class Solution {

    //找规律
    //对于奇数来说，二进制中1的个数为他上一个数字（偶数）+1
    //对于偶数来说，二进制中1的个数与和他除以2以后的那个数的1的个数是一样
    // （除以2相当于右移一位，而偶数最后一位肯定是0）
    public int[] countBits(int n) {
        int[] result = new int[n + 1];
        result[0] = 0;
        for (int i = 1; i <= n; i++) {
            if (i % 2 == 0)
                result[i] = result[i / 2];
            else
                result[i] = result[i - 1] + 1;

        }
        return result;
    }

    //暴力法
//    public int[] countBits(int n) {
//        int[] result = new int[n + 1];
//        result[0] = 0;
//        for (int i = 1; i <= n; i++) {
//            int cur = i;
//            while (cur != 0) {
//                if ((cur & 1) == 1) {
//                    result[i] += 1;
//                }
//                cur = cur >> 1;
//            }
//        }
//        return result;
//    }
}