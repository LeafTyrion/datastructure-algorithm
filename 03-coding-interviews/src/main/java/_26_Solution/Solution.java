package _26_Solution;

/**
 * @author YeYaqiao
 * 剑指 Offer 26. 树的子结构
 * 半知不解
 */
public class Solution {
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A == null || B == null)
            return false;
        //若找到疑似为的子结构，则必定有A的当前节点和B的根节点相同，
        //则可以进一步判断A的子节点内容是否和B的子节点内容是否相同
        if (A.val == B.val && recur(A.left, B.left) && recur(A.right, B.right))
            return true;
        //若上一步疑似的子结构被推翻，子继续遍历A树寻找疑似根节点
        return isSubStructure(A.left, B) || isSubStructure(A.right, B);
    }

    //判断子树内容是否相等
    private boolean recur(TreeNode A, TreeNode B) {
        //若B为null，则表示B遍历完成，疑似子结构被证实
        if (B == null)
            return true;
        //若A为null，则表示A遍历完成
        //但此时B还未遍历完成，所以当前判断的疑似子结构被否定掉
        if (A == null)
            return false;
        //若A和B都未遍历完成，则进一步比较A和B的值以及其子树的内容
        if (A.val == B.val && recur(A.left, B.left) && recur(A.right, B.right))
            return true;
        else
            return false;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}
