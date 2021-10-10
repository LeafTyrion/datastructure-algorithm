package _30_MinStack;

import java.util.Stack;

/**
 * @author YeYaqiao
 * 剑指 Offer 30. 包含min函数的栈
 */
public class MinStack {

    private final Stack<Integer> stack;
    private final Stack<Integer> temp;

    /**
     * initialize your data structure here.
     */
    public MinStack() {
        stack = new Stack<>();
        temp = new Stack<>();
    }

    public void push(int x) {
        stack.push(x);
        if (temp.isEmpty() || temp.peek() >= x)
            temp.push(x);
    }

    public void pop() {
        if (stack.pop().equals(temp.peek()))
            temp.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        return temp.peek();
    }
}
