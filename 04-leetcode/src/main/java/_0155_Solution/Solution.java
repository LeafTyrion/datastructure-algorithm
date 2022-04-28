package _0155_Solution;

import java.util.ArrayList;
import java.util.List;

/**
 * @author YeYaqiao
 * 155. 最小栈
 */
public class Solution {
    public static void main(String[] args) {

    }
}

class MinStack {

    int min;
    List<Integer> stack;
    int pointer;

    public MinStack() {
        this.stack = new ArrayList<>();
        this.pointer = -1;
    }

    public void push(int val) {
        if (stack.isEmpty()) {
            min = val;
        } else {
            if (val < min)
                min = val;
        }
        pointer++;
        stack.add(pointer, val);
    }

    public void pop() {
        if (!stack.isEmpty()) {
            Integer remove = stack.remove(pointer);
            pointer--;

            if (remove == min && pointer != -1) {
                min = stack.get(pointer);
                for (Integer integer : stack) {
                    if (integer < min)
                        min = integer;
                }
            }
        }
    }

    public int top() {
        return stack.get(pointer);
    }

    public int getMin() {
        return min;
    }
}