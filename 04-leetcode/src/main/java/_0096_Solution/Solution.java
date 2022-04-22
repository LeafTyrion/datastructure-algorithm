package _0096_Solution;

import java.util.HashMap;
import java.util.Map;

/**
 * @author YeYaqiao
 * 96. 不同的二叉搜索树
 */
public class Solution {

    //动态规划
//    public int numTrees(int n) {
//        int[] G = new int[n + 1];
//        for (int i = 0; i <= n; i++) {
//            if (i == 0 || i == 1) {
//                G[i] = 1;
//                continue;
//            }
//            for (int j = 1; j <= i; j++)
//                G[i] += G[j - 1] * G[i - j];
//        }
//        return G[n];
//    }

    //递归，使用 hashmap 优化
    Map<Integer, Integer> map = new HashMap<>();

    public int numTrees(int n) {
        if (n == 0 | n == 1)
            return 1;
        if (map.containsKey(n))
            return map.get(n);
        int count = 0;
        for (int i = 1; i <= n; i++) {
            int lefNum = numTrees(i - 1);
            int rightNum = numTrees(n - i);

            count += lefNum * rightNum;
        }
        map.put(n, count);
        return count;
    }
}
