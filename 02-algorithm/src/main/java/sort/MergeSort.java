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
        //对数组进行分组
        sort(arr, 0, arr.length - 1);
    }

    private void sort(int[] arr, int left, int right) {
        //如果区间内只有一个元素，则无需继续分组，直接返回
        if (left >= right)
            return;
        //以mid 包括 mid 右边为一个区间，mid之后的为一个区间
        int mid = left + (right - left) / 2;
        //递归对左右区间进行分组
        sort(arr, left, mid);
        sort(arr, mid + 1, right);
        //对分组的内容进行合并，合并过程中进行排序
        merge(arr, left, mid, right);
    }

    //合并的过程就是把两个排好序的数组合并到一起
    private void merge(int[] arr, int left, int mid, int right) {
        //用于暂时存放归并后的结果
        int[] tmp = new int[right - left + 1];
        int index = 0;//指向临时数组的指针
        int l = left;//left~mid 为排好序的左区间
        int r = mid + 1;//mid+1~right 为排好序的右区间
        while (l <= mid && r <= right) {
            if (arr[l] <= arr[r])
                tmp[index++] = arr[l++];
            else
                tmp[index++] = arr[r++];
        }
        while (l <= mid)
            tmp[index++] = arr[l++];
        while (r <= right)
            tmp[index++] = arr[r++];

        //将临时空间中的内容填充进原来的数组中
        System.arraycopy(tmp, 0, arr, left, tmp.length);
    }


    public static void main(String[] args) {
        MergeSort sort = new MergeSort();
        int[] array = new int[]{10, 3, 2, 5, 1, 9, 8, 7, 0, 6};
        sort.sort(array);
        System.out.println(Arrays.toString(array));
    }
}
