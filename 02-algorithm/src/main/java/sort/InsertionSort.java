package sort;

import java.util.Arrays;

/**
 * @author YeYaqiao
 * 插入排序
 * 最坏时间复杂度：O(n2)
 * 最好时间复杂度：O(n)
 * 平均时间复杂度：O(n2)
 * 空间复杂度：O(1)
 * 稳定性：稳定
 *
 * 假设第一个元素已经是排序好的元素，
 * 从第二个元素到最后一个元素开始扫描，将扫描到的每个元素放到正确的位置
 */
public class InsertionSort {
    public static void sort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int temp = array[i];

            int j = i;
            while (j > 0 && temp < array[j - 1]) {
                array[j] = array[j - 1];
                j--;
            }
//            if (j != i)
                array[j] = temp;
        }
    }

    public static void main(String[] args) {

        int[] array = new int[]{6, 5, 3, 2, 5, 1, 9, 8, 7, 0};
        sort(array);
        System.out.println(Arrays.toString(array));
    }
}
