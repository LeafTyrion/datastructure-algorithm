package _0448_Solution;

import java.util.ArrayList;
import java.util.List;

/**
 * @author YeYaqiao
 * 448. 找到所有数组中消失的数字
 */
public class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> list = new ArrayList<>();
        int index = 0;
        while (index < nums.length) {
            if (nums[index] - 1 != index) {
                if (nums[nums[index] - 1] == nums[index]) {
                    nums[index] = -1;
                    index++;
                } else {
                    int temp = nums[nums[index] - 1];
                    nums[nums[index] - 1] = nums[index];
                    nums[index] = temp;
                    if (nums[index] == -1)
                        index++;
                }
            } else {
                index++;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == -1)
                list.add(i + 1);
        }
        return list;

    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.findDisappearedNumbers(new int[]{4, 3, 2, 7, 8, 2, 3, 1});
    }
}
