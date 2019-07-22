package datastructure.thread;

/**
 * @description: 一定要写注释啊
 * @date: 2019-03-27 22:47
 * @author: 十一
 */
public class CASDemo2 {

    private  volatile int count = 0;

    public void add() {
        count ++;
    }
}
