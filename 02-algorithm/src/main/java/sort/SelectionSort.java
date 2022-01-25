package sort;

import java.util.Arrays;

/**
 * @author YeYaqiao
 * 选择排序
 * 最坏时间复杂度：O(n2)
 * 最好时间复杂度：O(n2)
 * 平均时间复杂度：O(n2)
 * 空间复杂度：O(1)
 * 稳定性：不稳定
 * <p>
 * 首先在未排序序列中找到最小（大）元素，存放到排序序列的起始位置。
 * 再从剩余未排序元素中继续寻找最小（大）元素，然后放到已排序序列的末尾。
 * 重复第二步，直到所有元素均排序完毕。
 */
public class SelectionSort {


    public static void sort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[minIndex] > array[j])
                    minIndex = j;
            }
            int temp = array[i];
            array[i] = array[minIndex];
            array[minIndex] = temp;
        }
    }

    public static void main(String[] args) {

        int[] array = new int[]{6, 5, 3, 2, 5, 1, 9, 8, 7, 0};
        sort(array);
        System.out.println(Arrays.toString(array));
    }
}
