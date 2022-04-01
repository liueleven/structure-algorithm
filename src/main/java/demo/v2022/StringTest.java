package demo.v2022;

/**
 * @description: 刘子清是个大傻逼
 * @date: 2022-03-06 17:27
 * @author: liuziqing
 */
public class StringTest {

    private static int num = 0;
//    public static void main(String[] args) throws InterruptedException {
//        MyThread t1 = new MyThread();
//        MyThread t2 = new MyThread();
//
//        t1.start();
//        t2.start();
//
//        t1.join();
//        t2.join();
//
//        System.out.println("num: " + num);
//
//    }


    public static void main(String[] args) {
        method(null);
    }
    public static void method(String param) {
        switch (param) {
            // 肯定不是进入这里
            case "sth":
                System.out.println("it's sth");
                break;
            // 也不是进入这里
            case "null":
                System.out.println("it's null");
                break;
            // 也不是进入这里
            default:
                System.out.println("default");
        }
    }

    static class MyThread extends Thread {

        @Override
        public void run() {
            for (int i = 0; i < 1000000; i++) {
                num++;
            }
        }
    }
}
