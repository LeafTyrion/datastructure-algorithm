package _461_Solution;

/**
 * @author YeYaqiao
 * 461. 汉明距离
 */
public class Solution {

    //利用位运算
    //异或^ 相同为0，不同为1
    public int hammingDistance(int x, int y) {
        int temp = x ^ y;
        int result = 0;
        while (temp != 0) {
            result += temp & 1;
            temp >>= 1;
        }
        return result;
    }

    //利用 API
//    public int hammingDistance(int x, int y) {
//        return Integer.bitCount(x ^ y);
//    }
}
