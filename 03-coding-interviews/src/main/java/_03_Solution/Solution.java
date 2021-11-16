package _03_Solution;

/**
 * @author YeYaqiao
 * 剑指 Offer 03. 数组中重复的数字
 */
public class Solution {

    //原地交换法，将每个数字放置到和索引值相同的位置
    public int findRepeatNumber(int[] nums) {
        int cur = 0;
        while (cur < nums.length) {
            //判断当前元素是否和索引对应，若对应，则开始遍历下一个元素
            if (nums[cur] == cur) {
                cur++;
                continue;
            }
            //判断当前元素对应的索引上的元素是否和当前元素相等，若相等则此元素重复
            int curNode = nums[cur];
            if (curNode == nums[curNode])
                return curNode;
            //将当前元素交换至其正确的索引位置
            int temp = nums[curNode];
            nums[curNode] = curNode;
            nums[cur] = temp;
        }
        return -1;
    }

    //利用 HashSet
//    public int findRepeatNumber(int[] nums) {
//        Set<Integer> set = new HashSet<>();
//        for (int num : nums) {
//            if (set.contains(num))
//                return num;
//            set.add(num);
//        }
//        return -1;
//    }

    //暴力遍历
//    public int findRepeatNumber(int[] nums) {
//        for (int i = 0; i < nums.length; i++) {
//            for (int j = i + 1; j < nums.length; j++) {
//                if (nums[i] == nums[j])
//                    return nums[i];
//            }
//        }
//        return -1;
//    }
}
