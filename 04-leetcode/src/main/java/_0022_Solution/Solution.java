package _0022_Solution;

import java.util.ArrayList;
import java.util.List;

/**
 * @author YeYaqiao
 * 22. 括号生成
 */
public class Solution {


    //暴力法，递归生成所有括号组合，判断括号组合是否合法
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        generateAll(new char[2 * n], 0, result);
        return result;
    }

    //递归生成所有可能得括号组合，每个位置都有两种可能
    private void generateAll(char[] current, int position, List<String> result) {
        if (position == current.length) {
            if (valid(current))
                result.add(new String(current));
        } else {
            current[position] = '(';
            generateAll(current, position + 1, result);
            current[position] = ')';
            generateAll(current, position + 1, result);
        }
    }

    //判断一个括号组合是否合法
    //左括号和右括号在位置上一一对应
    private boolean valid(char[] current) {
        int balance = 0;
        for (char c : current) {
            if (c == '(')
                balance++;
            else
                balance--;
            //若一开始时 ) 则balance为负数，非法组合
            if (balance < 0)
                return false;
        }
        return balance == 0;
    }
}
