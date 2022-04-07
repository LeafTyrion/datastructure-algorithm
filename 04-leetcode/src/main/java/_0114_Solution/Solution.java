package _0114_Solution;

/**
 * @author YeYaqiao
 * 114. 二叉树展开为链表
 */
public class Solution {

    TreeNode temp;

    //递归
    public void flatten(TreeNode root) {
        temp = root;
        dfs(root);
        root = temp.right;
    }

    private void dfs(TreeNode node) {
        if (node == null)
            return;

//        TreeNode leftTemp = node.left;
//        TreeNode rightTemp = node.right;

        temp.left = null;
        temp.right = node;
        temp = temp.right;


    }


    //迭代
//    public void flatten(TreeNode root) {
//        List<TreeNode> list = new ArrayList<>();
//        dfs(root, list);
//        TreeNode node = root;
//        for (int i = 1; i < list.size(); i++) {
//            node.left = null;
//            node.right = list.get(i);
//            node = node.right;
//        }
//    }
//
//    private void dfs(TreeNode node, List<TreeNode> list) {
//        if (node != null) {
//            list.add(node);
//            dfs(node.left, list);
//            dfs(node.right, list);
//        }
//    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
