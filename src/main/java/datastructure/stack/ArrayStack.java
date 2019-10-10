package datastructure.stack;


import java.util.Stack;

/**
 * @description: 基于数组的栈
 *                  栈的特点：
 *                      先进先出，后进后出
 *                      插入和删除都在一端
 * @date: 2019-02-22 00:34
 * @author: 十一
 */
public class ArrayStack<T> {

    private T[] stacks;

    /**
     * 栈的数量
     */
    private int count;

    /**
     * 栈的容量
     */
    private int capacity;

    public ArrayStack(T[] stacks, int count, int capacity) {
        this.stacks = stacks;
        this.count = count;
        this.capacity = capacity;
    }

    public ArrayStack(T[] stacks) {
        this.stacks = stacks;
        this.count = 0;
        this.capacity = stacks.length;
    }

    public void printall() {
        if(this.stacks == null) {
            return;
        }
        for(int i=this.stacks.length-1; i>=0; i--) {
            if(stacks[i] != null) {
                System.out.println(stacks[i]);
            }
        }
    }

    public void push(T data) {
        if(count >= this.stacks.length) return;
        this.stacks[count] = data;
        count ++;
    }

    public T pop() {
        if(count == 0) {
            return null;
        }
        T data = this.stacks[count-1];
        this.stacks[count-1] = null;
        count --;
        return data;
    }

    public T peek() {
        if(count == 0) {
            return null;
        }
        T data = this.stacks[count-1];
        return data;
    }

    public static void main(String[] args) {
        ArrayStack<Integer> stack = new ArrayStack<Integer>(new Integer[10],0,10);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.push(6);
        stack.push(7);
        stack.push(8);
        stack.push(9);
        stack.push(10);
        stack.pop();
        stack.push(11);
        stack.pop();
        stack.printall();
    }

    public int getCount() {
        return count;
    }
}
