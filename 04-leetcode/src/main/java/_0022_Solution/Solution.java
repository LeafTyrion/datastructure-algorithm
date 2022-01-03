package _0022_Solution;

import java.util.ArrayList;
import java.util.List;

/**
 * @author YeYaqiao
 * 22. 括号生成
 */
public class Solution {

    //dfs+剪枝
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        generateAll(n, result, "", 0, 0);
        return result;
    }

    private void generateAll(int n, List<String> result, String current, int left, int right) {
        //剪枝操作
        //当左括号的的数量大于n或者右括号的数量比左括号多，则进行剪枝
        if (right > left || left > n)
            return;
        //递归完成回溯
        if (current.length() == 2 * n) {
            result.add(current);
            return;
        }
        //先添加左括号，再添加右括号
        //由于java传递参数时是值传递，所以无需在回溯时对 current、left、right修改成原值
        generateAll(n, result, current + "(", left + 1, right);
        generateAll(n, result, current + ")", left, right + 1);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().generateParenthesis(1));
    }

    //dfs 全排列
    //暴力法，递归生成所有括号组合，判断括号组合是否合法
//    public List<String> generateParenthesis(int n) {
//        List<String> result = new ArrayList<>();
//        generateAll(n, result, "");
//        return result;
//    }
//
//    private void generateAll(int n, List<String> result, String current) {
//        if (current.length() == 2 * n) {
//            if (valid(current))
//                result.add(current);
//            return;
//        }
//        //先添加左括号，再添加右括号
//        generateAll(n, result, current + "(");
//        generateAll(n, result, current + ")");
//    }
//
//    private boolean valid(String current) {
//        int balance = 0;
//        for (char c : current.toCharArray()) {
//            if (c == '(')
//                balance++;
//            else
//                balance--;
//            if (balance < 0)
//                return false;
//        }
//        return balance == 0;
//    }

}
