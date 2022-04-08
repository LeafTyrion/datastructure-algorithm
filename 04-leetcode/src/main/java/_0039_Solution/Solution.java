package _0039_Solution;

import java.util.ArrayList;
import java.util.List;

/**
 * @author YeYaqiao
 * 39. 组合总和
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.combinationSum(new int[]{2, 3, 6, 7}, 7);
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(result, candidates, target, 0, new ArrayList<>(candidates.length), 0);
        return result;
    }

    private void dfs(List<List<Integer>> result, int[] candidates, int target, int sum, List<Integer> temp, int index) {

        if()

        for (int i = index; i < candidates.length; i++) {
            int cur = candidates[i];
            sum += cur;
            if (sum == target) {
                temp.add(cur);
                result.add(new ArrayList<>(temp));
                return;
            } else if (sum <= target) {
                if (index + 1 < candidates.length)
                    dfs(result, candidates, target, sum, temp, index + 1);
            }
        }
    }
}
