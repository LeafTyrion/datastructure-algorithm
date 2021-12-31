package _0019_Solution;

import java.util.List;
import java.util.Stack;

/**
 * @author YeYaqiao
 * 19. 删除链表的倒数第 N 个结点
 */
public class Solution {

    //栈解法
    public ListNode removeNthFromEnd(ListNode head, int n) {
        //由于存在头结点被删除的情况，因此需要赋值头结点
        ListNode dummy = new ListNode(0, head);
        Stack<ListNode> stack = new Stack<>();
        ListNode pointer = dummy;
        while (pointer != null) {
            stack.add(pointer);
            pointer = pointer.next;
        }
        for (int i = 0; i < n; i++)
            stack.pop();
        ListNode pre = stack.pop();
        pre.next = pre.next.next;
        return dummy.next;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
