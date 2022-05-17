package _0055_Solution;

/**
 * @author YeYaqiao
 * 55. 跳跃游戏
 */
public class Solution {
    //贪心算法
    public boolean canJump(int[] nums) {
        //用tmp记录可以跳跃的距离
        int tmp = nums[0];
        for (int i = 0; i < nums.length; i++) {
            //如果tmp 小于 i，表示当前位置无法跳出 0~i 这个区间
            if (tmp < i)
                return false;
            //更新tmp能跳跃的最大的距离
            tmp = Math.max(tmp, i + nums[i]);
        }
        return true;
    }
}
