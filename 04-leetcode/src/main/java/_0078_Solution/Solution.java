package _0078_Solution;

import java.util.ArrayList;
import java.util.List;

/**
 * @author YeYaqiao
 * 78. 子集
 */
public class Solution {

    //枚举法
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        //先添加一个空数组
        result.add(new ArrayList<>());
        for (int i = 0; i < nums.length; i++) {
            int size = result.size();
            for (int j = 0; j < size; j++) {
                //对结果数组进行遍历，对每个已有的结果添加如当前的元素，再放回结果数组中
                List<Integer> temp = new ArrayList<>(result.get(j));
                temp.add(nums[i]);
                result.add(temp);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.subsets(new int[]{1, 2, 3});
    }
}
