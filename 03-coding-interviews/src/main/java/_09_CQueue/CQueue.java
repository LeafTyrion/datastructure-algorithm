package _09_CQueue;

import java.util.Stack;

/**
 * @author YeYaqiao
 * 09.用两个栈实现一个队列
 */
public class CQueue {

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
