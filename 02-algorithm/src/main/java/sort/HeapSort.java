package sort;

import java.util.Arrays;

/**
 * @author YeYaqiao
 * <p>
 * 堆排序
 * <p>
 * 最坏时间复杂度：O(n2)
 * <p>
 * 最好时间复杂度：O(n)
 * <p>
 * 平均时间复杂度：O(n2)
 * <p>
 * 空间复杂度：O(1)
 * <p>
 * 稳定性：稳定
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

        //left<length 防止越界，如果当前节点比左子节点小
        if (left < length && array[left] > array[index])
            largest = left;
        if (right < length && array[right] > array[index])
            largest = right;
        //发生了交换
        if (largest != index) {
            swap(array, largest, index);
//            heapify();
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
        BubbleSort sort = new BubbleSort();
        int[] array = new int[]{1, 5, 3, 2, 5, 1, 9, 8, 7, 0};
        sort.sort(array);
        System.out.println(Arrays.toString(array));
    }
}
