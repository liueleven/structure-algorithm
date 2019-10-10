package v2;

/**
 * @description: 基于数组构建一个栈
 * 栈的操作：
 * 1、栈当前的元素数量
 * 3、入栈
 * 3、出栈
 * @date: 2019-08-05 22:14
 * @author: 十一
 */
public class LArrayStack<T> {

    /**
     * 栈的数量
     */
    private int count;

    /**
     * 栈的容量
     */
    private int capacity;

    private T[] stacks;

    public LArrayStack( T[] stacks) {
        this.count = 0;
        this.capacity = stacks.length;
        this.stacks = stacks;
    }

    /**
     * 栈当前的元素数量
     * @return
     */
    public int getCount() {
        return count;
    }

    /**
     * 入栈
     * @param e
     * @return 返回该元素
     */
    public T push(T e) {

        if (count >= capacity) {
            System.out.println("stack has max");
            return null;
        }
        stacks[count++] = e;
        return e;
    }

    /**
     * 出栈
     * @return
     */
    public T pop() {
        if (count == 0) {
            return null;
        }
        T e = stacks[count-1];
        stacks[count-1] = null;
        count --;
        return e;
    }

    public void printAll() {
        for (T stack : stacks) {
            System.out.print(stack + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {

        LArrayStack<String> arrayStack = new LArrayStack<>(new String[4]);
        System.out.println("栈的数量："+arrayStack.count);
        System.out.println("栈的容量："+arrayStack.capacity);
        arrayStack.push("a");
        arrayStack.push("b");
        arrayStack.push("c");
        arrayStack.push("d");
        arrayStack.push("e");
        arrayStack.printAll();
        arrayStack.pop();
        arrayStack.pop();
        arrayStack.printAll();
        arrayStack.push("f");
        System.out.println("栈的数量："+arrayStack.count);
        System.out.println("栈的容量："+arrayStack.capacity);
        arrayStack.printAll();
    }

}
