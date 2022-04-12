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


        return result;
    }

    private Map<Integer, String> getMap() {
        Map<Integer, String> map = new HashMap<>();
        char a = 'a';
        for (int i = 2; i <= 9; i++) {
            StringBuilder temp = new StringBuilder();
            for (int j = 0; j < 3; j++) {
                temp.append(a);
                a += 1;
            }
            if (i == 7) {
                temp.append(a);
                a += 1;
            }
            if (i == 9) {
                temp.append(a);
                a += 1;
            }
            map.put(i, temp.toString());
        }
        return map;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.letterCombinations("2");
    }
}
