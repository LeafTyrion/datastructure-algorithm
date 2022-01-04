package _0104_Solution;

/**
 * @author YeYaqiao
 * 104. 二叉树的最大深度
 */
public class Solution {

    private int maxDeep = 0;

    //DFS 深度优先，每次遍历到叶子节点记录深度，并选出最深的
    public int maxDepth(TreeNode root) {
        dfs(root, 0);
        return maxDeep;
    }

    private void dfs(TreeNode node, int deep) {
        if (node == null) {
            maxDeep = Math.max(deep, maxDeep);
            return;
        }
        deep++;
        dfs(node.left, deep);
        dfs(node.right, deep);
    }

    //BFS 广度优先遍历，利用队列来一层一层遍历
//    public int maxDepth(TreeNode root) {
//        if (root == null)
//            return 0;
//        int deep = 0;
//
//        Queue<TreeNode> queue = new LinkedList<>();
//        queue.add(root);
//        while (!queue.isEmpty()) {
//            //记录上层父节点的数量，控制内层保证每次遍历时都能清空队列中的父节点
//            int size = queue.size();
//            while (size != 0) {
//                TreeNode node = queue.poll();
//                if (node.left != null)
//                    queue.add(node.left);
//                if (node.right != null)
//                    queue.add(node.right);
//                size--;
//            }
//            deep++;
//        }
//        return deep;
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
