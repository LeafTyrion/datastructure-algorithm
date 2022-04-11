package _0039_Solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author YeYaqiao
 * 39. 组合总和
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.combinationSum(new int[]{2, 3, 6, 7}, 7));
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(result, candidates, target, 0, new ArrayList<>(candidates.length), 0);
        return result;
    }

    private void dfs(List<List<Integer>> result, int[] candidates, int target, int sum, List<Integer> temp, int index) {
        if (sum == target) {
            result.add(new ArrayList<>(temp));
            return;
        }

        for (int i = index; i < candidates.length; i++) {
            int value = sum + candidates[i];
            if (value > target)
                break;
            temp.add(candidates[i]);
            dfs(result, candidates, target, value, temp, i);
            temp.remove(temp.size() - 1);
        }
    }
}
