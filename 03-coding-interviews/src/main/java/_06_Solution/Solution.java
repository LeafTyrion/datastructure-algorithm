package _06_Solution;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author YeYaqiao
 * 剑指 Offer 06. 从尾到头打印链表
 */
public class Solution {

    //栈解法
//    public int[] reversePrint(ListNode head) {
//        Stack<Integer> temp = new Stack<>();
//
//        ListNode node = head;
//        while (node != null) {
//            temp.push(node.val);
//            node = node.next;
//        }
//
//        int[] result = new int[temp.size()];
//
//        for (int i = 0; i < result.length; i++) {
//            result[i] = temp.pop();
//        }
//
//        return result;
//    }

    //递归解法
    List<Integer> temp = new ArrayList<>();

    public int[] reversePrint(ListNode head) {

        recur(head);

        int[] result = new int[temp.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = temp.get(i);
        }
        return result;
    }

    void recur(ListNode head) {
        if (head == null)
            return;
        recur(head.next);
        temp.add(head.val);
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
