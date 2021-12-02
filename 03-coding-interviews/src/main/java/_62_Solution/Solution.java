package _62_Solution;

import java.util.ArrayList;
import java.util.List;

/**
 * @author YeYaqiao
 * 剑指 Offer 62. 圆圈中最后剩下的数字
 */
public class Solution {

    //一共n个数字，每次都删除第m个数字
    //约瑟夫环，动态规划
    public int lastRemaining(int n, int m) {
        //倒推法，当只剩一个数字时，他的位置索引为0
        //所以他上一轮的位置为 (0+m)%数字的长度，之后的以此类推
        int index = 0;
        //当只剩一个数字时，index 肯定为 0，所以可以直接从 2 开始计算
        for (int i = 2; i <= n; i++) {
            //i为当前数组的长度
            index = (index + m) % i;
        }
        return index;
    }

    //模拟剔除
//    public int lastRemaining(int n, int m) {
//        List<Integer> temp = new ArrayList<>();
//        for (int i = 0; i < n; i++) {
//            temp.add(i);
//        }
//
//        //从数组第一个元素开始寻找
//        int index = 0;
//        while (n > 1) {
//            //假设当前要被删除的元素是index，则下一个要被删除的元素是 index+m，
//            //由于当前位置被删除后，后面的元素会前移，实际被删除的元素为 index+m-1
//            index = (index - 1 + m) % n;
//            temp.remove(index);
//            n--;
//        }
//        return temp.get(0);
//    }
}
