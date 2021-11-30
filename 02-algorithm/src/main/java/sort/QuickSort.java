package sort;

import java.util.Arrays;

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
        //快速排序递归入口
        quickSort(array, 0, array.length - 1);
    }

    //递归排列子序列
    private void quickSort(int[] arr, int left, int right) {
        if (left < right) {
            //以 pivot 为中轴，将整个序列分隔后，并获取分隔的索引位置
            int partition = partition(arr, left, right);
            quickSort(arr, left, partition - 1);
            quickSort(arr, partition + 1, right);
        }
    }

    //对当前序列按照基准值进行分隔
    //获取基准值的索引位置
    private int partition(int[] arr, int left, int right) {
        //每次都设置子序列第一个元素为基准值，同时空出了子序列最左边的位置
        int pivot = arr[left];
        //从两端开始遍历元素与pivot比较
        while (left < right) {
            //若右边的元素比基准值大，则满足较大元素在基准值右边的条件
            //右指针持续左移，直到找到一个小于基准值的元素
            while (arr[right] >= pivot && left < right)
                right--;
            //将这个较大的元素放在子序列的左边，此时当前 right 位置相当于空出
            arr[left] = arr[right];
            //若左边的元素比基准值小，则满足较小元素在基准值左边的条件
            //左指针持续左移，直到找到一个大于基准值的元素
            while (arr[left] <= pivot && left < right)
                left++;
            //将这个较大的元素放在子序列右边刚刚空出的那个位置，此时当前 left 位置相当于空出
            arr[right] = arr[left];
        }
        //当left==right时，此时left右边元素都比 pivot 大，左边的元素都比 pivot 小
        //并且当前位置是空出的，将 pivot 放置在当前位置
        arr[left] = pivot;
        //并返回中轴的下标
        return left;
    }

    public static void main(String[] args) {
        QuickSort sort = new QuickSort();
        int[] array = new int[]{10, 3, 2, 5, 1, 9, 8, 7, 0};
        sort.sort(array);
        System.out.println(Arrays.toString(array));
    }
}
