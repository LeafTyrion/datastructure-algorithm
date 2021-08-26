#### 30. 包含 min 函数的栈

定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的 min 函数在该栈中，调用 min、push 及 pop 的时间复杂度都是 O(1)。

**示例:**

```
MinStack minStack = new MinStack();
minStack.push(-2);
minStack.push(0);
minStack.push(-3);
minStack.min();   --> 返回 -3.
minStack.pop();
minStack.top();      --> 返回 0.
minStack.min();   --> 返回 -2.
```

##### 辅助栈解法



```java
class MinStack {

    private Stack<Integer> stack;
    private Stack<Integer> temp;

    /**
     * initialize your data structure here.
     */
    public MinStack() {
        stack = new Stack<>();
        temp = new Stack<>();
    }

    public void push(int x) {
        stack.push(x);
        if (temp.isEmpty() || temp.peek() >= x) {
            temp.push(x);
        }

    }

    public void pop() {
        if (stack.pop().equals(temp.peek())) {
            temp.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        return temp.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.min();
 */

```



