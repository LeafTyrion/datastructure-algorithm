package _52_Solution;

/**
 * @author YeYaqiao
 * 剑指 Offer 52. 两个链表的第一个公共节点
 */
public class Solution {

    //双指针
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode A = headA, B = headB;
        //公共节点，即地址值相同的节点
        while (A != B) {
            A = A != null ? A.next : headB;
            B = B != null ? B.next : headA;
        }
        return B;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
