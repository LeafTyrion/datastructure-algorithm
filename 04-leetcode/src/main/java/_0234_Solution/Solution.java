package _0234_Solution;

/**
 * @author YeYaqiao
 * 234. 回文链表
 */
public class Solution {
    public boolean isPalindrome(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        //快慢指针找到链表中点
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode reverse = reverse(slow);
        while (reverse != null) {
            if (reverse.val != head.val)
                return false;
            reverse = reverse.next;
            head = head.next;
        }
        return true;
    }

    private ListNode reverse(ListNode head) {
        ListNode pre = null;
        while (head != null) {
            ListNode temp = head.next;
            head.next = pre;
            pre = head;
            head = temp;
        }
        return pre;
    }


    //例用栈
//    public boolean isPalindrome(ListNode head) {
//        Deque<ListNode> deque = new LinkedList<>();
//
//        while (head != null) {
//            deque.add(head);
//            head = head.next;
//        }
//        while (!deque.isEmpty() && deque.getFirst().val == deque.getLast().val && deque.size() > 1) {
//            deque.removeFirst();
//            deque.removeLast();
//        }
//        return deque.size() == 1 || deque.isEmpty();
//    }
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

