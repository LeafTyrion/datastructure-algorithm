package _33_Solution;

/**
 * @author YeYaqiao
 * 剑指 Offer 33. 二叉搜索树的后序遍历序列
 */
public class Solution {
    public boolean verifyPostorder(int[] postorder) {
        return recur(postorder, 0, postorder.length - 1);
    }

    private boolean recur(int[] postorder, int left, int right) {
        //若左边界大于等于右边界，则说明此节点是叶子节点
        if (left >= right)
            return true;
        //获取当前树的根节点
        int root = postorder[right];

        //从左向右遍历数组寻找第一个比根节点大的值的索引，其后的元素都为根节点的右子树
        int mid = left;
        while (postorder[mid] < root) {
            mid++;
        }
        //此时temp和mid 之前的元素都为左子树，之后的元素都为右子树的
        int temp = mid;

        //右子树的内容都应该大于根节点，否则构不成排序二叉树
        while (temp < right) {
            if (postorder[temp++] < root)
                return false;
        }
        //分别递归当前节点的左右子树
        return recur(postorder, left, mid - 1) && recur(postorder, mid, right - 1);
    }
}
