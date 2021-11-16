#### 09. 用两个栈实现一个队列

用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead 操作返回 -1 )

示例 1：

输入：
["CQueue","appendTail","deleteHead","deleteHead"]
[[],[3],[],[]]
输出：[null,null,3,-1]
示例 2：

输入：
["CQueue","deleteHead","appendTail","appendTail","deleteHead","deleteHead"]
[[],[],[5],[2],[],[]]
输出：[null,-1,null,null,5,2]

##### 双栈解法

队列的特性是先进先出，栈的特性是先进后出

设置两个栈 input 和 output；每次新增数据的时候，向 input 中进行压栈操作，相当于在队列尾部插入数据；删除数据时，若 output 为空，先将 input 中的元素全部出栈并压入 output，然后 output 执行出栈操作

```java
class CQueue {

    private final Stack<Integer> input;
    private final Stack<Integer> output;

    public CQueue() {
        input = new Stack<>();
        output = new Stack<>();
    }

    public void appendTail(int value) {
        input.push(value);
    }

    public int deleteHead() {
        if (output.isEmpty()) {
            if (input.isEmpty()) {
                return -1;
            } else {
                while (!input.isEmpty()) {
                    output.push(input.pop());
                }
            }
        }
        return output.pop();
    }
}
```
