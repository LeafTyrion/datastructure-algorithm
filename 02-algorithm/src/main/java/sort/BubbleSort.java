package sort;

import java.util.Arrays;

/**
 * @author YeYaqiao
 * 冒泡排序
 * 最坏时间复杂度：O(n2)
 * 最好时间复杂度：O(n)
 * 平均时间复杂度：O(n2)
 * 空间复杂度：O(1)
 * 稳定性：稳定
 * <p>
 * 比较相邻的元素。如果第一个比第二个大，就交换他们两个。
 */
public class BubbleSort {

    public void sort(int[] array) {

        for (int i = 0; i < array.length - 1; i++) {
            //设置标记表示是否发生交换
            boolean isSwap = false;
            //内层循环将较大的值排在数组后面
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    //若当前元素比其后面一个元素大，则交换
                    int temp = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = temp;
                    //发生交换以后，说明这个数组肯定不是个排序数组了
                    isSwap = true;
                }
            }
            //若一轮比较后没有发生交换，则证明此数组已经是有序数组
            if (!isSwap)
                return;
        }
    }

    public static void main(String[] args) {
        BubbleSort sort = new BubbleSort();
        int[] array = new int[]{1, 5, 3, 2, 5, 1, 9, 8, 7, 0};
        sort.sort(array);
        System.out.println(Arrays.toString(array));
    }
}