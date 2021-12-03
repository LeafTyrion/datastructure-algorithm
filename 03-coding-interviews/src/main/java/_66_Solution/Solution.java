package _66_Solution;

/**
 * @author YeYaqiao
 * 剑指 Offer 66. 构建乘积数组
 */
public class Solution {

    public int[] constructArr(int[] a) {
        int[] result = new int[a.length];
        int temp = 1;
        //第一次循环计算出i之前的乘积，第二次循环计算出i之后的乘积
        //若[1,2,3,4,5]
        //第一次循环结束后result为[1,1,2,6,24]
        for (int i = 0; i < a.length; i++) {
            result[i] = temp;
            temp = temp * a[i];
        }
        //第二次循环计算i之后的值，然后与第一次的相乘
        //第二次循环后的结果为[120,60,20,5,1]
        temp=1;
        for (int i = a.length - 1; i >= 0; i--) {
            result[i] = result[i] * temp;
            temp = temp * a[i];
        }
        return result;
    }

    //暴力法超时
//    public int[] constructArr(int[] a) {
//        int[] result = new int[a.length];
//        for (int i = 0; i < a.length; i++) {
//            int temp = 1;
//            for (int j = 0; j < a.length; j++) {
//                if (i == j)
//                    continue;
//                temp = temp * a[j];
//            }
//            result[i] = temp;
//        }
//        return result;
//    }
}
