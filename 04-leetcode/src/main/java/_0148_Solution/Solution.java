package _0148_Solution;

/**
 * @author YeYaqiao
 * 148. 排序链表
 */
public class Solution {

    //自底向上进行合并
    public ListNode sortList(ListNode head) {

        if (head == null)
            return null;
        int length = 0;
        ListNode pointer = head;
        while (pointer != null) {
            length++;
            pointer = pointer.next;
        }

        ListNode dump = new ListNode(0, head);

        //subLength 来表示子链表的长度，子链表每合并一次，长度就乘2
        for (int subLength = 1; subLength < length; subLength *= 2) {
            ListNode pre = dump, cur = dump.next;
            //两组两组的获取子链表，并且每两组合并
            while (cur != null) {
                //获取第一组子链表
                ListNode head1 = cur;
                for (int i = 1; i < subLength && cur.next != null; i++) {
                    cur = cur.next;
                }
                //获取第二组子链表，并且与第一组子链表直接断开连接
                ListNode head2 = cur.next;
                cur.next = null;//断开连接
                cur = head2;
                for (int i = 1; i < subLength && cur != null && cur.next != null; i++) {
                    cur = cur.next;
                }
                //第二组链表也要和后面的链表断开连接，但是需要用 next 记录一下后续为分组的链表的头节点
                ListNode next = null;
                if (cur != null) {
                    next = cur.next;//next记录后续链表的头节点
                    cur.next = null;//第二组和后续的链表断开连接
                }
                pre.next = merge(head1, head2);//合并第一组和第二组链表，并追加到 dump 节点后
                //移动 pre 到归并好的链表的最后，用于将分组好的链表相连起来
                while (pre.next != null) {
                    pre = pre.next;
                }
                //将当前节点移动到后续的未分组的链表，继续进行进行分组操作
                cur = next;
            }
        }
        return dump.next;
    }


    //    public ListNode sortList(ListNode head) {
//        //遵循左闭右开的原则
//        return sortList(head, null);
//    }
//
//    //自顶向下进行递归合并
//    //利用快慢指针对链表进行分组
//    public ListNode sortList(ListNode head, ListNode tail) {
//        //当分组无元素则直接返回
//        if (head == null)
//            return null;
//        //继续分组直到每个组都只有一个元素为止
//        if (head.next == tail) {
//            head.next = null;
//            return head;
//        }
//        //利用快慢指针对链表进行二分
//        ListNode slow = head, fast = head;
//        while (fast != tail) {
//            slow = slow.next;
//            fast = fast.next;
//            if (fast != tail)
//                fast = fast.next;
//        }
//
//        ListNode mid = slow;
//        ListNode l1 = sortList(head, mid);
//        ListNode l2 = sortList(mid, tail);
//        return merge(l1, l2);
//    }
//
    public ListNode merge(ListNode l1, ListNode l2) {
        ListNode dump = new ListNode(0);
        ListNode t = dump, t1 = l1, t2 = l2;
        while (t1 != null && t2 != null) {
            if (t1.val > t2.val) {
                t.next = t2;
                t2 = t2.next;
            } else {
                t.next = t1;
                t1 = t1.next;
            }
            t = t.next;
        }

        if (t1 != null)
            t.next = t1;
        if (t2 != null)
            t.next = t2;
        return dump.next;
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
