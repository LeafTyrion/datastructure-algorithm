package _0406_Solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author YeYaqiao
 * 406. 根据身高重建队列
 */
public class Solution {

    public int[][] reconstructQueue(int[][] people) {

        int length = people.length;
        int[][] result = new int[length][];
        List<Integer> temp = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            temp.add(i);
        }
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                int res = o1[0] - o2[0];
                if (res < 0)
                    return -1;
                else if (res == 0)
                    return o2[1] - o1[1];
                return 1;
            }
        });

        for (int i = 0; i < result.length; i++) {
            int k = people[i][1];
            int index = temp.get(k);
            result[index] = people[i];
            temp.remove(k);
        }
        return result;
    }

//        public int[][] reconstructQueue(int[][] people) {
//        Arrays.sort(people, new Comparator<int[]>() {
//            public int compare(int[] person1, int[] person2) {
//                if (person1[0] != person2[0]) {
//                    return person2[0] - person1[0];
//                } else {
//                    return person1[1] - person2[1];
//                }
//            }
//        });
//        List<int[]> ans = new ArrayList<int[]>();
//        for (int[] person : people) {
//            ans.add(person[1], person);
//        }
//        return ans.toArray(new int[ans.size()][]);
//    }

    public static void main(String[] args) {

        Solution solution = new Solution();
        solution.reconstructQueue(new int[][]{{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}});

    }
}
