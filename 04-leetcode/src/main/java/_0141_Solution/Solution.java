package _0141_Solution;

/**
 * @author YeYaqiao
 * 141. 环形链表
 */
public class Solution {

    //快慢指针
    public boolean hasCycle(ListNode head) {
//        if (head == null)
//            return false;
//        ListNode slow = head;
//        ListNode fast = head.next;
//        while (slow != fast) {
//            if (slow == null || fast == null || fast.next == null)
//                return false;
//            slow = slow.next;
//            fast = fast.next.next;
//        }
//        return true;

        if (head == null)
            return false;
        ListNode slow = head, fast = head;
        do {
            if (fast == null || fast.next == null)
                return false;
            slow = slow.next;
            fast = fast.next.next;
        } while (fast != slow);
        return true;
    }


    //hashset
//    public boolean hasCycle(ListNode head) {
//        Set<ListNode> set = new HashSet<>();
//        while (head != null) {
//            if (set.contains(head))
//                return true;
//            set.add(head);
//            head = head.next;
//        }
//        return false;
//    }


    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

}
