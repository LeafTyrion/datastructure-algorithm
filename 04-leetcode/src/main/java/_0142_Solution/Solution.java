package _0142_Solution;

/**
 * @author YeYaqiao
 * 142. 环形链表 II
 */
public class Solution {
    //快慢指针
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        do {
            if (fast == null || fast.next == null)
                return null;
            slow = slow.next;
            fast = fast.next.next;
        } while (fast != slow);

        fast = head;
        //找到相遇的点后，将fast指向head，步长设置为1
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
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
