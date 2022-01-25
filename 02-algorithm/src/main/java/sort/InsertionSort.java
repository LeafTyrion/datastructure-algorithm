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
 * <p>
 * 假设第一个元素已经是排序好的元素，
 * 从第二个元素到最后一个元素开始扫描，将扫描到的每个元素放到排好的元素序列中的正确位置
 */
public class InsertionSort {
    public static void sort(int[] array) {
        //设第一个元素已经是有序元素，从第二个元素开始遍历
        for (int i = 1; i < array.length; i++) {
            int temp = array[i];

            int j = i;
            //遍历之前排好的有序数组
            //若有序元素比当前元素大，则将其向后移动，给待排元素空出位置
            while (j > 0 && temp < array[j - 1]) {
                array[j] = array[j - 1];
                j--;
            }
            //若j==i，则说明则说明待排元素已经在正确的位置上
            if (j != i)
                array[j] = temp;
        }
    }

    public static void main(String[] args) {

        int[] array = new int[]{6, 5, 3, 2, 5, 1, 9, 8, 7, 0};
        sort(array);
        System.out.println(Arrays.toString(array));
    }
}
