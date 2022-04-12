package _0017_Solution;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author YeYaqiao
 * 17. 电话号码的字母组合
 */
public class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits.length() == 0)
            return result;
        backTrace(result, digits, getMap(), 0, new StringBuilder());
        return result;
    }

    private void backTrace(List<String> result, String digits, Map<Character, String> map, int index, StringBuilder temp) {
        if (temp.length() == digits.length()) {
            result.add(temp.toString());
        } else {
            char digit = digits.charAt(index);
            String content = map.get(digit);
            for (int i = 0; i < content.length(); i++) {
                temp.append(content.charAt(i));
                backTrace(result, digits, map, index + 1, temp);
                temp.deleteCharAt(index);
            }
        }
    }

    private Map<Character, String> getMap() {
        Map<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        return map;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.letterCombinations("23");
    }
}
