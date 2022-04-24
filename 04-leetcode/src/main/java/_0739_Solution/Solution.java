package _0739_Solution;

import java.util.Stack;

/**
 * @author YeYaqiao
 * 739. 每日温度
 */
public class Solution {

    //栈解法
    public int[] dailyTemperatures(int[] temperatures) {
        int length = temperatures.length;
        int[] result = new int[length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < length; i++) {
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int pre = stack.pop();
                result[pre] = i - pre;
            }
            stack.push(i);
        }
        return result;
    }


    //暴力法
//    public int[] dailyTemperatures(int[] temperatures) {
//        int length = temperatures.length;
//        int[] result = new int[length];
//        for (int i = 0; i < length - 1; i++) {
//            int days = 0;
//            for (int j = i + 1; j < length; j++) {
//                days++;
//                if (temperatures[j] > temperatures[i]) {
//                    result[i] = days;
//                    break;
//                }
//            }
//        }
//        return result;
//    }
}
