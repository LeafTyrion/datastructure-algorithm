package _009_CQueue;

import java.util.Stack;

/**
 * @author YeYaqiao
 * 剑指 Offer 09. 用两个栈实现队列
 */
public class CQueue {

    private final Stack<Integer> in;
    private final Stack<Integer> out;

    public CQueue() {
        in = new Stack<>();
        out = new Stack<>();
    }

    public void appendTail(int value) {
        in.push(value);
    }

    public int deleteHead() {
        if (out.isEmpty()) {
            while (!in.isEmpty()) {
                out.push(in.pop());
            }
        }
        if (out.isEmpty())
            return -1;
        return out.pop();
    }
}
