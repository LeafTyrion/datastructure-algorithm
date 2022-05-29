package _0013_Solution;

import java.util.HashMap;
import java.util.Map;

/**
 * @author YeYaqiao
 * 13. 罗马数字转整数
 */
public class Solution {
    private static Map<Character, Integer> mapping = new HashMap<>();

    static {
        mapping.put('I', 1);
        mapping.put('V', 5);
        mapping.put('X', 10);
        mapping.put('L', 50);
        mapping.put('C', 100);
        mapping.put('D', 500);
        mapping.put('M', 1000);

    }

    public int romanToInt(String s) {
        int res=0;
        int length=s.length();
        for (int i = 0; i < length; i++) {

        }

    }
}
