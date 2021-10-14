package search;

import java.util.Arrays;

/**
 * @author YeYaqiao
 * 二分查找（适用于排好序的顺序存储）
 * 时间复杂度：O(logN)
 * 空间复杂度：O(1)
 */
public class BinarySearch {

    public boolean search(int[] array, int target) {

        Arrays.sort(array);

        int min = 0;
        int max = array.length - 1;
        int middle;

        while (min <= max) {
//            middle = (min + max) / 2;
            middle = min + (max - min) / 2;//此写法可以防止相加后 int 溢出

            if (array[middle] == target)
                return true;
            if (array[middle] < target)
                min = middle + 1;
            if (array[middle] > target)
                max = middle - 1;
        }
        return false;
    }
}
