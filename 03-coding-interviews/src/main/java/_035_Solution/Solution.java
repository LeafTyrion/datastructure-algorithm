package _035_Solution;

import java.util.HashMap;
import java.util.Map;

/**
 * @author YeYaqiao
 * 剑指 Offer 35. 复杂链表的复制
 */
public class Solution {

    //拼接+拆分
    public Node copyRandomList(Node head) {
        if (head == null)
            return null;
        Node cur = head;
        while (cur != null) {
            //创建当前元素对应的新元素
            Node temp = new Node(cur.val);
            //将新元素的插入到当前元素之后
            temp.next = cur.next;
            cur.next = temp;
            cur = temp.next;
        }
        cur = head;
        while (cur != null) {
            //将新元素的 random 指向当前元素的 random
            if (cur.random != null)
                cur.next.random = cur.random.next;
            cur = cur.next.next;
        }
        //将新链表和原链表拆分出来
        cur = head.next;
        Node res = cur;
        Node pre = head;
        while (cur.next != null) {
            pre.next = pre.next.next;
            cur.next = cur.next.next;
            pre = pre.next;
            cur = cur.next;
        }
        //原链表结尾需要单独处理，否则还指向新创建的元素
        pre.next = null;
        return res;
    }

    //hashmap 解法
//    public Node copyRandomList(Node head) {
//        if (head == null)
//            return null;
//        Node cur = head;
//        //用于存储原来的元素和新建的元素
//        Map<Node, Node> map = new HashMap<>();
//        while (cur != null) {
//            //遍历同时新建元素并填充 val
//            map.put(cur, new Node(cur.val));
//            cur = cur.next;
//        }
//        //从头开始遍历
//        cur = head;
//        while (cur != null) {
//            //将新建的元素指向新建的下一个元素
//            map.get(cur).next = map.get(cur.next);
//            //将新建的元素指向新建的随机元素
//            map.get(cur).random = map.get(cur.random);
//            cur = cur.next;
//        }
//        //返回新建的第一个元素
//        return map.get(head);
//    }
}

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}