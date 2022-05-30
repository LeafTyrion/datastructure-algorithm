package _0013_Solution;

import java.util.HashMap;
import java.util.Map;

/**
 * @author YeYaqiao
 * 13. 罗马数字转整数
 */
public class Solution {
    private static final Map<Character, Integer> mapping = new HashMap<>();

    static {
        mapping.put('I', 1);
        mapping.put('V', 5);
        mapping.put('X', 10);
        mapping.put('L', 50);
        mapping.put('C', 100);
        mapping.put('D', 500);
        mapping.put('M', 1000);
    }

    // LVIII -> 58
    public int romanToInt(String s) {
        int res = 0;
        int length = s.length();
        for (int i = 0; i < length; i++) {
            Integer value = mapping.get(s.charAt(i));
            //当前罗马字符小于右边的字符，则结果中减去当前字符的值
            if (i < length - 1 && value < mapping.get(s.charAt(i + 1)))
                res -= value;
            else
                //罗马字符不小于右边的字符时，则结果中加上当前位置的值
                //对于最后一个位罗马数字，直接加进去即可
                res += value;
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.romanToInt("III");
    }
}
