package _56_I_Solution;

/**
 * @author YeYaqiao
 * 剑指 Offer 56 - I. 数组中数字出现的次数
 */
public class Solution {

    //位运算
    //异或^ 相同为0，不同为1，任意数字A和0做异或运算后，结果还是A
    //与 &，都为1则为1
    //或 |，都为0则为0
    public int[] singleNumbers(int[] nums) {

        //利用异或运算获取两个不重复的数字的异或结果 xor
        int xor = 0;
        for (int num : nums)
            xor = xor ^ num;
        //对于 xor 中，其二进制从右到左第一个不为0的位置
        //利用与运算获取这个差异位置
        int bit = 1;
        int index = 0;
        while ((bit & xor) != 1) {
            xor = xor >> 1;
            index++;
        }

        //遍历整个数组，使用&比对这个差异位置，并做^异或运算，分别获取结果
        int x = 0, y = 0;
        for (int num : nums) {
            int temp = num >> index;
            if ((temp & 1) == 1)
                x ^= num;
            else
                y ^= num;
        }

        return new int[]{x, y};
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.singleNumbers(new int[]{1, 1, 2, 2, 4});
    }
}
