package _0056_Solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author YeYaqiao
 * 56. 合并区间
 */
public class Solution {

    //排序+双指针
    public int[][] merge(int[][] intervals) {
        int len = intervals.length;
        List<int[]> tmp = new ArrayList<>();
        //按照左边界大小进行排序
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        tmp.add(intervals[0]);
        int left = intervals[0][0];
        int right = intervals[0][1];
        for (int i = 1; i < len; i++) {
            int tmpLeft = intervals[i][0];
            int tmpRight = intervals[i][1];

            //左边界大于右边界，则是独立的
            if (tmpLeft > right) {
                tmp.add(intervals[i]);
                int[] ints = tmp.get(tmp.size() - 1);
                left = ints[0];
                right = ints[1];
            } else {
                //更新左右边界，合并数组
                left = Math.min(left, tmpLeft);
                right = Math.max(right, tmpRight);
                int[] ints = tmp.get(tmp.size() - 1);
                ints[0] = left;
                ints[1] = right;
            }
        }
        return tmp.toArray(new int[tmp.size()][]);
    }
}
