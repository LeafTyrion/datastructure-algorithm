package _24_Solution;

import java.util.List;
import java.util.Stack;

/**
 * @author YeYaqiao
 * 剑指 Offer 24. 反转链表
 */
public class Solution {

    //辅助栈解法
//    public ListNode reverseList(ListNode head) {
//        Stack<Integer> temp = new Stack<>();
//        while (head != null) {
//            temp.push(head.val);
//            head = head.next;
//        }
//        ListNode node = null;
//        if (!temp.isEmpty()) {
//            node = new ListNode(temp.pop());
//            ListNode pointer = node;
//            while (!temp.isEmpty()) {
//                pointer.next = new ListNode(temp.pop());
//                pointer = pointer.next;
//            }
//        }
//
//        return node;
//    }

    //递归解法
//    public ListNode reverseList(ListNode head) {
//        return recur(head, null);
//    }
//
//    private ListNode recur(ListNode cur, ListNode pre) {
//        if (cur == null)
//            return pre;
//        ListNode res = recur(cur.next, cur);
//        cur.next = pre;
//        return res;
//    }


    //辅助指针解法
    public ListNode reverseList(ListNode head) {

        ListNode cur = head;
        ListNode pre = null;

        while (cur != null) {
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }

}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}