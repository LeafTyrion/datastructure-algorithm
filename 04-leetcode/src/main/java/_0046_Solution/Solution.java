package _0046_Solution;

import java.util.ArrayList;
import java.util.List;

/**
 * @author YeYaqiao
 * 46. 全排列
 */
public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(result, new ArrayList<>(), nums, new int[nums.length]);
        return result;
    }

    //visited 用于记录递归到当前栈时，哪些元素访问了，哪些没访问
    private void dfs(List<List<Integer>> result, List<Integer> temp, int[] nums, int[] visited) {
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
            visited[i] = 0;
            //回溯时将temp中的当前栈添加的元素去除，即最后一个元素
            temp.remove(temp.size() - 1);
        }
    }


}
