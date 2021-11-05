#### 反转链表

定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。 

示例:

输入: 1->2->3->4->5->NULL
输出: 5->4->3->2->1->NULL

##### 迭代法

```java
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class _003_Solution.Solution {
    public ListNode reverseList(ListNode head) {

        ListNode currentNode = head;
        ListNode previousNode = null;

        while (currentNode != null){
            ListNode temp = currentNode.next;
            currentNode.next = previousNode;
            previousNode = currentNode;
            currentNode = temp;
        }
        return previousNode;
    }
}
```


