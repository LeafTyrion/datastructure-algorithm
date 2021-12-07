package _0002_Solution;

/**
 * @author YeYaqiao
 * 2. 两数相加
 */
public class Solution {
    //[9,9]
    //[9,9,9]
    //递归
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return recur(l1, l2, 0);
    }

    private ListNode recur(ListNode l1, ListNode l2, int x) {

        int left = 0;
        int right = 0;

        if (l1 != null)
            left = l1.val;
        if (l2 != null)
            right = l2.val;
        if (l1 == null && l2 == null && x == 0)
            return null;
        //构造当前节点
        ListNode result = new ListNode((left + right + x) % 10);
        //构造下一个节点
        result.next = recur(l1 == null ? null : l1.next, l2 == null ? null : l2.next, (left + right + x) / 10);
        //返回当前节点
        return result;
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
