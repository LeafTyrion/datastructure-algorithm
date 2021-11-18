package _18_Solution;

/**
 * @author YeYaqiao
 * 剑指 Offer 18. 删除链表的节点
 */
public class Solution {

    //遍历法
    public ListNode deleteNode(ListNode head, int val) {
        //特殊情况，当头节点为要查找的值，则直接放回下一个节点即可
        if (head.val == val)
            return head.next;
        //获取当前节点
        ListNode pointer = head.next;
        //记录前一个几点
        ListNode pre = head;
        while (pointer != null) {
            //若当前节点为要查找的值，则将前一个节点指向后一个节点即可
            if (pointer.val == val) {
                pre.next = pointer.next;
                break;
            }
            //指针后移
            pre = pointer;
            pointer = pointer.next;
        }
        return head;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}