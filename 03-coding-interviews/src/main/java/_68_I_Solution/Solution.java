package _68_I_Solution;

/**
 * @author YeYaqiao
 * 剑指 Offer 68 - I. 二叉搜索树的最近公共祖先
 */
public class Solution {


    //递归
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root.val < p.val && root.val < q.val)
            return lowestCommonAncestor(root.right, p, q);
        if (root.val > p.val && root.val > q.val)
            return lowestCommonAncestor(root.left, p, q);
        return root;
    }

    //迭代
//    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
//        if(p.val > q.val) { // 保证 p.val < q.val
//            TreeNode tmp = p;
//            p = q;
//            q = tmp;
//        }
//        while(root != null) {
//            if(root.val < p.val) // p,q 都在 root 的右子树中
//                root = root.right; // 遍历至右子节点
//            else if(root.val > q.val) // p,q 都在 root 的左子树中
//                root = root.left; // 遍历至左子节点
//            else break;
//        }
//        return root;
//    }

}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}