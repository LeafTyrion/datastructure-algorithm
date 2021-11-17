package _42_Solution;

/**
 * @author YeYaqiao
 * 剑指 Offer 42. 连续子数组的最大和
 */
public class Solution {

    //动态规划 优化
    //f(i)=Max{f(i-1)+nums[i], nums[i]}
    public int maxSubArray(int[] nums) {
        int pre = 0, maxAns = nums[0];
        for (int x : nums) {
            //当前位置的原始到之前所有原始的和大于当前元素的话，当前子序列暂时还处于递增状态
            //若当前到之前元素的和还没有当前元素大，则证明之前的元素和为负数，则可以抛弃，从当前元素开始计算和 pre
            pre = Math.max(pre + x, x);
            //判断将最大的和赋值给 maxAns
            maxAns = Math.max(maxAns, pre);
        }
        return maxAns;
    }

    //动态规划 未优化
//    public int maxSubArray(int[] nums) {
//        int pre = 0;
//        int result = nums[0];
//
//        for (int num : nums) {
//            pre = Math.max(pre + num, num);
//            if (pre > result)
//                result = pre;
//        }
//        return result;
//    }

    //分治算法，不会
//    static class Status {
//        public int lSum, rSum, mSum, iSum;
//
//        public Status(int lSum, int rSum, int mSum, int iSum) {
//            this.lSum = lSum;
//            this.rSum = rSum;
//            this.mSum = mSum;
//            this.iSum = iSum;
//        }
//    }
//
//    public int maxSubArray(int[] nums) {
//        return getInfo(nums, 0, nums.length - 1).mSum;
//    }
//
//    private Status getInfo(int[] a, int l, int r) {
//        if (l == r) {
//            return new Status(a[l], a[l], a[l], a[l]);
//        }
//        int m = (l + r) >> 1;
//        Status lSub = getInfo(a, l, m);
//        Status rSub = getInfo(a, m + 1, r);
//        return pushUp(lSub, rSub);
//    }
//
//    private Status pushUp(Status l, Status r) {
//        int iSum = l.iSum + r.iSum;
//        int lSum = Math.max(l.lSum, l.iSum + r.lSum);
//        int rSum = Math.max(r.rSum, r.iSum + l.rSum);
//        int mSum = Math.max(Math.max(l.mSum, r.mSum), l.rSum + r.lSum);
//        return new Status(lSum, rSum, mSum, iSum);
//    }

    //暴力法,会超时
//    public int maxSubArray(int[] nums) {
//        if (nums.length == 0)
//            return 0;
//        if (nums.length == 1)
//            return nums[0];
//
//        int result = Integer.MIN_VALUE;
//        for (int i = 0; i < nums.length; i++) {
//            int temp = nums[i];
//            if (temp > result)
//                result = temp;
//            for (int j = i + 1; j < nums.length; j++) {
//                temp = temp + nums[j];
//                if (temp > result)
//                    result = temp;
//            }
//        }
//        return result;
//    }
}
