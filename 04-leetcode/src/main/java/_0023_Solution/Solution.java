package _0023_Solution;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author YeYaqiao
 * 23. 合并K个升序链表
 */
public class Solution {

    //优先队列
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0)
            return null;

        ListNode result = new ListNode();
        ListNode pointer = result;
        PriorityQueue<ListNode> queue = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });

        for (ListNode list : lists) {
            if (list == null)
                continue;
            queue.add(list);
        }
        while (!queue.isEmpty()) {
            ListNode node = queue.poll();
            pointer.next = node;
            pointer = pointer.next;
            if (node.next != null)
                queue.add(node.next);

        }
        return result.next;
    }

    //暴力法
//    public ListNode mergeKLists(ListNode[] lists) {
//        ListNode result = null;
//        for (ListNode list : lists) {
//            if (result == null && list != null) {
//                result = list;
//                continue;
//            }
//            ListNode temp = new ListNode();
//            ListNode p1 = result;
//            ListNode p2 = list;
//            ListNode p = temp;
//            while (p1 != null && p2 != null) {
//                if (p1.val > p2.val) {
//                    p.next = p2;
//                    p2 = p2.next;
//                } else {
//                    p.next = p1;
//                    p1 = p1.next;
//                }
//                p = p.next;
//            }
//            if (p1 == null)
//                p.next = p2;
//            if (p2 == null)
//                p.next = p1;
//            result = temp.next;
//        }
//        return result;
//    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode n1 = new ListNode(2);
        ListNode n2 = new ListNode(1);

        ListNode[] list = new ListNode[]{n1, n2};
        solution.mergeKLists(list);
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
