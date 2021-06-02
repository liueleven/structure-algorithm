package v4.list;

/**
 * @description: 数组实现链表
 * @date: 2021-06-02 22:46
 * @author: liuziqing
 */
public class ArrayList {

    static int[] data = new int[10];
    static int[] next = new int[10];

    /**
     *
     * @param idx   上个节点索引
     * @param p     下个节点索引
     * @param val   下个节点的值
     */
    public static void add(int idx, int p, int val) {
        next[idx] = p;
        data[p] = val;
    }

    public static void main(String[] args) {
        add(0,1,1);
        add(1,2,2);
        add(2,3,3);
        add(3,4,4);

        int idx = 0;
        while (next[idx] != 0) {
            System.out.println(next[idx]);
            int p = next[idx];
            idx = p;
        }
    }
}
