package _36_Solution;

/**
 * @author YeYaqiao
 * 剑指 Offer 36. 二叉搜索树与双向链表
 */
public class Solution {
    //搜索二叉树采用中序遍历即可得到排序后的结果
    //使用双指针来控制
    Node pre, head;
    public Node treeToDoublyList(Node root) {
        if (root == null)
            return null;
        dfs(root);
        //收尾相连
        head.left = pre;
        pre.right = head;
        //返回头结点
        return head;
    }

    //中序遍历
    private void dfs(Node node) {
        //递归结束条件
        if (node == null)
            return;
        //递归左节点，找到较小的元素
        dfs(node.left);
        //若pre为空，则说明这是头结点
        if (pre != null)
            //不为空，则说明是后继节点
            pre.right = node;
        else
            //保存头结点
            head = node;
        //让当前节点的左指针指向前一个节点
        node.left = pre;
        //暂存当前节点，用于指向后续节点
        pre = node;
        dfs(node.right);
    }
}

// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
}
