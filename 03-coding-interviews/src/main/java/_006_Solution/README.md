#### 06. 从尾到头打印链表

输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。

##### 栈解法

利用栈先进后出的特性获取反向的链表值

1. 遍历链表的同时将节点的值存入栈中；
2. 创建大小为栈大小的数组，然后执行出栈操作，并将值存入数组

```java
class Solution {
    public int[] reversePrint(ListNode head) {

        Stack<Integer> stack = new Stack<>();
        while (head != null) {
            stack.push(head.val);
            head = head.next;
        }

        int size = stack.size();
        int[] result = new int[size];
        for (int i = 0; i < size; i++) {
            result[i] = stack.pop();
        }

        return result;
    }
}
```

时间复杂度 O(n)：一共需要遍历2n次

空间复杂度 O(n)：需要创建1个大小为n的栈

##### 递归法

利用递归遍历链表获取最后一个节点，回溯时将值加入一个 list 中，获得一个逆序的结果





