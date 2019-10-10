package v3.leetcode.stack;

import java.util.Stack;

/**
 * @description: 栈实现队列，用两个栈来，一个是input，一个是output，只要是out的操作，就把input的放到output
 *                  然后在从output中出
 * @date: 2019-10-10 19:02
 * @author: 十一
 */
public class _06Queue {

    private  Stack<Integer> input ;
    private  Stack<Integer> output ;
    /** Initialize your data structure here. */
    public _06Queue() {
        input = new Stack();
        output = new Stack();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        input.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if (output.isEmpty()) {
            while (!input.isEmpty()) {
                output.push(input.pop());
            }
        }
        return output.pop();
    }

    /** Get the front element. */
    public int peek() {
        if (output.isEmpty()) {
            while (!input.isEmpty()) {
                output.push(input.pop());
            }
        }
        return output.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        if (output.isEmpty() && input.isEmpty()) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        _06Queue queue = new _06Queue();
        queue.push(1);
        queue.push(2);
        System.out.println(queue.peek());
        System.out.println(queue.pop());
        System.out.println(queue.empty());
    }
}
