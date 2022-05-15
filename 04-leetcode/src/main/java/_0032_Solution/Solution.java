package _0032_Solution;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author YeYaqiao
 * 32. 最长有效括号
 */
public class Solution {
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

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.longestValidParentheses("(()");
    }
}
