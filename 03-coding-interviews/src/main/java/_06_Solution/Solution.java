package _06_Solution;

import java.util.ArrayList;
import java.util.List;

/**
 * @author YeYaqiao
 * 剑指 Offer 06. 从尾到头打印链表
 */
public class Solution {

    List<Integer> temp = new ArrayList<>();

    //递归法
    public int[] reversePrint(ListNode head) {
        recurs(head);
        int[] result = new int[temp.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = temp.get(i);
        }
        return result;
    }

    public void recurs(ListNode node) {
        if (node != null) {
            recurs(node.next);
            temp.add(node.val);
        }
    }


    //栈解法
//    public int[] reversePrint(ListNode head) {
//        Stack<Integer> stack=new Stack<>();
//        ListNode pointer=head;
//        while (pointer!=null){
//            stack.push(pointer.val);
//            pointer=pointer.next;
//        }
//        int [] result=new int[stack.size()];
//        for (int i = 0; i < result.length; i++) {
//            result[i]=stack.pop();
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
