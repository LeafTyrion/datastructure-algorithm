package sort;

import java.util.Arrays;

/**
 * @author YeYaqiao
 * 希尔排序
 * 最坏时间复杂度：O(n2)
 * 最好时间复杂度：O(n)
 * 平均时间复杂度：O(n2)
 * 空间复杂度：O(1)
 * 稳定性：不稳定
 * <p>
 * 先将整个待排序的记录序列分割成为若干子序列分别进行直接插入排序，
 * 待整个序列中的记录"基本有序"时，再对全体记录进行依次直接插入排序。
 */
public class ShellSort {

    public void sort(int[] array) {


    }

    public static void main(String[] args) {
        BubbleSort sort = new BubbleSort();
        int[] array = new int[]{1, 5, 3, 2, 5, 1, 9, 8, 7, 0};
        sort.sort(array);
        System.out.println(Arrays.toString(array));
    }
}