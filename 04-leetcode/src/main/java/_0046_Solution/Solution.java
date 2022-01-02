package _0046_Solution;

import java.util.ArrayList;
import java.util.List;

/**
 * @author YeYaqiao
 * 46. 全排列
 */
public class Solution {

    //dfs 暴力递归
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(result, new ArrayList<>(), nums, new int[nums.length]);
        return result;
    }

    private void dfs(List<List<Integer>> result, List<Integer> temp, int[] nums, int[] visited) {
        //递归出口
        if (temp.size() == nums.length) {
            result.add(new ArrayList<>(temp));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (visited[i] == 1)
                continue;
            visited[i] = 1;
            temp.add(nums[i]);
            dfs(result, temp, nums, visited);
            //回溯时清除已经访问过的元素
            visited[i] = 0;
            temp.remove(temp.size() - 1);
        }
    }

}
