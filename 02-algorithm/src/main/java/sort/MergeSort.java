package sort;

import java.util.Arrays;

/**
 * @author YeYaqiao
 * 归并排序
 * 最坏时间复杂度：O(nlogn)
 * 最好时间复杂度：O(nlogn)
 * 平均时间复杂度：O(nlogn)
 * 空间复杂度：O(n)
 * 稳定性：稳定
 * <p>
 * 对数组区间内进行不断划分，是区间内保持有序，然后对有序的区间进行合并，合并成一个大的有序的区间
 */
public class MergeSort {

    public void sort(int[] arr) {
        //对数组进行分组，读取元素时遵循左闭右开
        sort(arr, 0, arr.length);
    }

    //对传入的数组进行分组
    private void sort(int[] arr, int left, int right) {
        //当前分组只有一个元素时直接返回
        if (right - left <= 1)
            return;
        //mid 是向上取整的
        int mid = left + (right - left) / 2;
        //对当前组进行划分，知道每个组都只有一个元素
        sort(arr, left, mid);
        sort(arr, mid, right);
        //分组完毕回溯时对两个组进行合并操作
        merge(arr, left, mid, right);
    }

    //合并的过程就是把两个排好序的数组合并到一起
    private void merge(int[] arr, int left, int mid, int right) {
        int[] tmp = new int[right - left];
        int index = 0;
        int l = left, r = mid;
        while (l < mid && r < right) {
            if (arr[l] > arr[r])
                tmp[index++] = arr[r++];
            else
                tmp[index++] = arr[l++];
        }
        while (l < mid)
            tmp[index++] = arr[l++];
        while (r < right)
            tmp[index++] = arr[r++];

        //将合并的结果拷贝至以left开头的位置
        System.arraycopy(tmp, 0, arr,  left, tmp.length);
    }

    public static void main(String[] args) {
        MergeSort sort = new MergeSort();
        int[] array = new int[]{10, 3, 2, 5, 1, 9, 8, 7, 0, 6};
        sort.sort(array);
        System.out.println(Arrays.toString(array));
    }
}
