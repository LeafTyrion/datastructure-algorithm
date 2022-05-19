package _0215_Solution;

import java.util.Arrays;

/**
 * @author YeYaqiao
 * 215. 数组中的第K个最大元素
 */
public class Solution {
    //获取降序数组，构建小顶堆
    public int findKthLargest(int[] nums, int k) {
        int length = nums.length;
        buildMinHeap(nums, length);
        //堆化完成，数组内第一个元素肯定是较小的值
        while (length - 1 >= 0) {
            swap(nums, 0, length - 1);
            length--;
            heapify(nums, 0, length);
        }
        System.out.println(Arrays.toString(nums));
        return nums[k - 1];
    }

    //构建小顶堆
    private void buildMinHeap(int[] nums, int length) {
        //将数组的前一半，（非叶子节点进行堆化操作）
        for (int i = length / 2; i >= 0; i--) {
            heapify(nums, i, length);
        }
    }

    //堆化操作，让每个父节点都比子节点小
    private void heapify(int[] nums, int index, int length) {
        int left = 2 * index + 1;
        int right = 2 * index + 2;

        //获取最小值的节点
        int min = index;
        if (left < length && nums[left] < nums[min])
            min = left;
        if (right < length && nums[right] < nums[min])
            min = right;

        if (min != index) {
            //交换当前父节点和较小值节点的元素内容
            swap(nums, min, index);
            //原来最小值节点的内容被更新成了较大的值，需要重新对它及其子节点进行堆化
            heapify(nums, min, length);
        }
    }


    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }


    //快速排序
//    public int findKthLargest(int[] nums, int k) {
//        int length = nums.length;
//        quickSort(nums, 0, length - 1);
//        return nums[length - k];
//    }
//
//    private void quickSort(int[] nums, int left, int right) {
//        if (left < right) {
//            int partition = partition(nums, left, right);
//            quickSort(nums, left, partition - 1);
//            quickSort(nums, partition + 1, right);
//        }
//
//    }
//
//    private int partition(int[] nums, int left, int right) {
//        int pivot = nums[left];
//        while (left < right) {
//            while (nums[right] >= pivot && left < right)
//                right--;
//            nums[left] = nums[right];
//            while (nums[left] <= pivot && left < right)
//                left++;
//            nums[right] = nums[left];
//        }
//        nums[left] = pivot;
//        return left;
//    }


//    public int findKthLargest(int[] nums, int k) {
//        Arrays.sort(nums);
//        return nums[nums.length - k + 1];
//    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.findKthLargest(new int[]{3, 2, 4, 1}, 2);
    }

}
