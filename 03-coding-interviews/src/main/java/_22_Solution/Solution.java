package _22_Solution;

/**
 * @author YeYaqiao
 * 剑指 Offer 22. 链表中倒数第k个节点
 */
public class Solution {

    //双指针
    public ListNode getKthFromEnd(ListNode head, int k) {
        //设置一个头指针，一个尾指针
        ListNode former = head, latter = head;
        //将尾指针移动至和头指针距离为k的位置
        for (int i = 1; i < k; i++)
            latter = latter.next;
        //将两个指针同时向后移动，直到尾指针到最后一个
        while (latter.next != null) {
            former = former.next;
            latter = latter.next;
        }
        //此时头指针为查找的节点
        return former;
    }

    //暴力遍历，计算链表大小
//    public ListNode getKthFromEnd(ListNode head, int k) {
//        int listLength = 0;
//        ListNode currentNode = head;
//        while (currentNode != null) {
//            //获取链表大小
//            listLength++;
//            currentNode = currentNode.next;
//        }
//        //获取目标节点正序序号
//        int targetIndex = listLength - k;
//        ListNode targetNode = head;
//        if (targetIndex == 0)
//            return targetNode;
//
//        for (int i = 0; i < targetIndex; i++)
//            targetNode = targetNode.next;
//
//        return targetNode;
//    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
