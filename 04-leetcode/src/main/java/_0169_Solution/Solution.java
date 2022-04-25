package _0169_Solution;

/**
 * @author YeYaqiao
 * 169. 多数元素
 */
public class Solution {
    //摩尔投票,遍历数组，每遇见一个相同的数字 sum++，sum为0的时候换成当前数字即可
    public int majorityElement(int[] nums) {
        int result = 0;
        int sum = 0;

        for (int num : nums) {
            if (sum == 0) {
                result = num;
                sum++;
            } else {
                if (num == result) {
                    sum++;
                } else {
                    sum--;
                }
            }
        }
        return result;
    }


    //hash
//    public int majorityElement(int[] nums) {
//        int length = nums.length;
//        Map<Integer, Integer> map = new HashMap<>(length);
//
//        for (int key : nums) {
//            if (map.containsKey(key)) {
//                map.put(key, map.get(key) + 1);
//            } else {
//                map.put(key, 1);
//            }
//        }
//
//        int temp = length / 2;
//        for (Map.Entry<Integer, Integer> m : map.entrySet()) {
//            if (m.getValue() > temp)
//                return m.getKey();
//        }
//        return -1;
//    }
}
