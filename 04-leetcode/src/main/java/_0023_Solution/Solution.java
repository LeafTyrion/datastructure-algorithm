package _0023_Solution;

/**
 * @author YeYaqiao
 * 23. 合并K个升序链表
 */
public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode result = new ListNode();
        for (ListNode list : lists) {
            merge(result, list);
        }
        return result.next;
    }

    public void merge(ListNode master, ListNode branch) {
        ListNode temp = new ListNode();
        while (master != null && branch != null) {
            if (master.val > branch.val) {
                temp.next = branch;
                branch = branch.next;
            } else {
                temp.next = master;
                master = master.next;
            }
            temp = temp.next;
        }
        if (master == null)
            temp.next = branch;
        else if (branch == null)
            temp.next = master;
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
