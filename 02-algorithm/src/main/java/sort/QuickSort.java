package sort;

import java.util.Arrays;
import java.util.Queue;

/**
 * @author YeYaqiao
 * 快速排序
 * 最坏时间复杂度：O(n2)
 * 最好时间复杂度：O(nlogn)
 * 平均时间复杂度：O(nlogn)
 * 空间复杂度：O(nlogn)
 * 稳定性：不稳定
 */
public class QuickSort {

    public void sort(int[] array) {
        quickSort(array, 0, array.length - 1);
    }

    private void quickSort(int[] arr, int left, int right) {
        if (left < right) {
            int partitionIndex = partition(arr, left, right);
            quickSort(arr, left, partitionIndex - 1);
            quickSort(arr, partitionIndex + 1, right);
        }
    }

    private int partition(int[] arr, int left, int right) {
        // 设定基准值（pivot）
        int pivot = left;
        int index = pivot + 1;
        for (int i = index; i <= right; i++) {
            if (arr[i] < arr[pivot]) {
                swap(arr, i, index);
                index++;
            }
        }
        swap(arr, pivot, index - 1);
        return index - 1;
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        QuickSort sort = new QuickSort();
        int[] array = new int[]{6, 5, 3, 2, 5, 1, 9, 8, 7, 0};
        sort.sort(array);
        System.out.println(Arrays.toString(array));
    }
}
