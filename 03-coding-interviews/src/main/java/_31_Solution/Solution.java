package _31_Solution;

import java.util.Stack;

/**
 * @author YeYaqiao
 * 剑指 Offer 31. 栈的压入、弹出序列
 */
public class Solution {

    //模拟
    //模拟元素入栈后要出栈的过程
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();

        int i = 0;
        for (int num : pushed) {
            stack.push(num);
            //每次入栈一个元素，就判断当元素是否是下一次出栈的那个元素
            while (!stack.isEmpty() && stack.peek() == popped[i]) {
                stack.pop();
                i++;
            }
        }
        //若符合出栈的顺序，则当前辅助栈应该为空
        return stack.isEmpty();
    }
}
