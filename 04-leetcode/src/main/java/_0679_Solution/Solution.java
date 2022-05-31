package _0679_Solution;

import java.util.ArrayList;
import java.util.List;

/**
 * @author YeYaqiao
 * 679. 24 点游戏
 */
public class Solution {
    private static final Double EPS = 1e-6;
    private static final int ADD = 0, SUBTRACT = 1, MULTIPLY = 2, DEVICE = 3;

    public boolean judgePoint24(int[] cards) {
        List<Double> input = new ArrayList<>();
        for (int card : cards) {
            input.add((double) card);
        }
        return solve(input);
    }

    public boolean solve(List<Double> input) {
        int size = input.size();
        if (size == 0)
            return false;
        if (size == 1)
            //结果符合精度范围内则返回true
            return Math.abs(24 - input.get(0)) < EPS;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (i == j)
                    continue;
                List<Double> tmp = new ArrayList<>();
                //将剩下的不参与运算的存入tmp中
                for (int k = 0; k < size; k++) {
                    if (k != i && k != j)
                        tmp.add(input.get(k));
                }
                double a = input.get(i);
                double b = input.get(j);
                //两两比较进行加减乘除运算
                for (int k = 0; k < 4; k++) {
                    if (k == ADD) {
                        tmp.add(a + b);
                    } else if (k == SUBTRACT) {
                        tmp.add(a - b);
                    } else if (k == MULTIPLY) {
                        tmp.add(a * b);
                    } else {
                        //除法除数处理精度问题
                        if (b < EPS)
                            continue;
                        tmp.add(a / b);
                    }
                    //运算完毕后将tmp中的数组继续进行四则运算
                    if (solve(tmp))
                        return true;
                    //不符合条件就移走
                    tmp.remove(tmp.size() - 1);
                }
            }
        }
        return false;
    }
}
