package _0160_Solution;

/**
 * @author YeYaqiao
 * 160. 相交链表
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode A = headA, B = headB;
        while (A != B) {
            if (A != null)
                A = A.next;
            else
                A = headB;
            if (B != null)
                B = B.next;
            else
                B = headA;
        }
        return A;
    }
}


class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}
