package sort;

import java.util.Arrays;

/**
 * @author YeYaqiao
 * <p>
 * 堆排序
 * <p>
 * 最坏时间复杂度：O(nlogn)
 * <p>
 * 最好时间复杂度：O(nlogn)
 * <p>
 * 平均时间复杂度：O(nlogn)
 * <p>
 * 空间复杂度：O(1)
 * <p>
 * 稳定性：不稳定
 * <p>
 * 二叉堆是一个数组，在元素的逻辑关系上可以被看成一个近似的完全二叉树
 * <p>
 * 大顶堆：每个节点都大于等于其子节点，用于升序排列
 * <p>
 * 小顶堆：每个节点都小于等于其子节点，用于降序排列
 * <p>
 * 堆排序分为两步：建堆和排序
 */
public class HeapSort {
    public void sort(int[] array) {
        int length = array.length;
        buildMaxHeap(array, length);

        //根据大顶堆的性质可知，i位置的元素一定大于等于2*i和2*i+1
        //根节点一定是最大的元素
        for (int i = length - 1; i > 0; i--) {
            //遍历整个大顶堆
            //将根节点的元素与数组最后一个未排序的元素进行交换
            swap(array, 0, i);
            //然后对剩下的数组从根节点进行重新堆化
            length--;
            heapify(array, 0, length);
        }

    }

    /**
     * 将数组转换为大顶堆结果
     *
     * @param array 数组
     */
    private void buildMaxHeap(int[] array, int length) {
        for (int i = length / 2; i >= 0; i--)
            heapify(array, i, length);
    }

    /**
     * 对数组进行堆化操作
     *
     * @param array  原数组
     * @param index  需要进行堆化的索引位置
     * @param length 长度
     */
    private void heapify(int[] array, int index, int length) {
        //获取 index 节点的左右两个子节点
        int left = 2 * index + 1;
        int right = 2 * index + 2;
        //记录当前最大的元素的索引
        int largest = index;

        //left<length 防止越界，比较出找出三个节点中最大的节点
        if (left < length && array[left] > array[largest])
            largest = left;
        if (right < length && array[right] > array[largest])
            largest = right;
        //发生了交换
        if (largest != index) {
            swap(array, largest, index);
            //largest 这个位置的元素被替换成了较小的值，需要重新 heapify
            heapify(array, largest, length);
        }
    }


    /**
     * 交换数组中两个索引位置的元素内容
     *
     * @param array 数组
     * @param i     待交换的元素索引位置
     * @param j     待交换的元素索引位置
     */
    private void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String[] args) {
        HeapSort sort = new HeapSort();
        int[] array = new int[]{1, 5, 3, 2, 5, 1, 9, 8, 7, 0};
        sort.sort(array);
        System.out.println(Arrays.toString(array));
    }
}
