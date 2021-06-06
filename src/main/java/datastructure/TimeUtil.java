package datastructure;

/**
 * @description: 刘子清是个大傻逼
 * @date: 2021-06-06 07:20
 * @author: liuziqing
 */
public class TimeUtil {

    public interface Task {
        void execute();
    }

    public static void execute(String name , Task task) {
        System.out.println("耗时统计，方法名称：["+name+"]");
        long b = System.currentTimeMillis();
        task.execute();
        long e = System.currentTimeMillis();
        System.out.println("耗时：" + (e-b) +" ms");
        System.out.println("------------------------");
    }
}
