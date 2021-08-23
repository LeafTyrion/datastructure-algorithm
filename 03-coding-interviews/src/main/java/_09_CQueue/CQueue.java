package _09_CQueue;

import java.util.Stack;

/**
 * @author YeYaqiao
 * 09. 用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead 操作返回 -1 )
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
