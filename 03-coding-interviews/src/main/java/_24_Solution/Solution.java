package _24_Solution;

/**
 * @author YeYaqiao
 * 剑指 Offer 24. 反转链表
 */
public class Solution {

    //双指针解法
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        while (head != null) {
            ListNode temp = head.next;
            head.next = pre;
            pre = head;
            head = temp;
        }
        return pre;
    }

    //递归
//    public ListNode reverseList(ListNode head) {
//        return recur(head,null);
//    }
//
//    //递归时将当前元素指向前一个元素
//    public ListNode recur(ListNode cur,ListNode pre) {
//        if(cur==null)
//            return pre;
//        ListNode next=cur.next;
//        cur.next=pre;
//        return recur(next, cur);
//    }

    //栈解法
//    public ListNode reverseList(ListNode head) {
//        if(head==null)
//            return null;
//
//        Stack<ListNode> temp = new Stack<>();
//        while (head != null) {
//            temp.push(head);
//            head = head.next;
//        }
//
//        ListNode result = temp.peek();
//        while (!temp.isEmpty()) {
//            ListNode cur = temp.pop();
//            if (temp.isEmpty())
//                cur.next = null;
//            else
//                cur.next = temp.peek();
//        }
//        return result;
//    }

    //数组解法
//    public ListNode reverseList(ListNode head) {
//        List<ListNode> temp = new ArrayList<>();
//        while (head != null) {
//            temp.add(head);
//            head = head.next;
//        }
//        ListNode result = null;
//        for (int i = temp.size() - 1; i >= 0; i--) {
//            if (i == temp.size() - 1)
//                result = temp.get(i);
//            if (i == 0) {
//                temp.get(i).next = null;
//                break;
//            }
//            temp.get(i).next = temp.get(i - 1);
//        }
//        return result;
//    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}