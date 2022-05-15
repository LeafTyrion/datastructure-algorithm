package _0032_Solution;

import java.util.Stack;

/**
 * @author YeYaqiao
 * 32. 最长有效括号
 */
public class Solution {
    //栈解法
    public int longestValidParentheses(String s) {
        int max = 0;
        Stack<Integer> stack = new Stack<>();
        //-1 作为虚拟边界
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            //左括号直接入栈，等待右括号的匹配
            if (s.charAt(i) == '(')
                stack.push(i);
            else {
                //存入新的边界
                stack.pop();
                //如果是右括号，先判断当前栈是否空，若为空，则将右括号入栈，作为边界
                if (stack.isEmpty())
                    stack.push(i);
                //若栈不为空，说明存放边界+左括号索引...,当前索引减去左括号索引获取长度
                else
                    max = Math.max(max, i - stack.peek());
            }

        }
        return max;
    }


    //暴力超时
//    public int longestValidParentheses(String s) {
//        //有效的括号肯定是偶数
//        int max = 0;
//        for (int i = 2; i <= s.length(); i += 2) {
//            for (int j = 0; j <= s.length() - i; j++) {
//                if (valid(s.substring(j, j + i))) {
//                    max = Math.max(max, i);
//                    break;
//                }
//            }
//        }
//        return max;
//    }
//
//    public boolean valid(String s) {
//        Deque<Character> deque = new LinkedList<>();
//        for (int i = 0; i < s.length(); i++) {
//            char c = s.charAt(i);
//            if (i == 0 && c == ')')
//                return false;
//            if (deque.isEmpty())
//                deque.push(c);
//            else {
//                if (c == ')' && deque.peek() == '(')
//                    deque.pop();
//                else
//                    deque.push(c);
//            }
//
//        }
//        return deque.isEmpty();
//    }

}
