package carry.分布式专题.第一讲分布式的发展与演进.案例.Interrupt;

import java.util.concurrent.TimeUnit;

public class InterruptDemo {

    private static int i = 0;

    public static void main(String[] args) throws InterruptedException {


        Thread thread = new Thread(() -> {
            while (!Thread.currentThread().isInterrupted()) {
                i++;
            }
            System.out.println("i:" + i);
        }, " InterruptDemo");
        thread.start();
        TimeUnit.SECONDS.sleep(1);
       //  thread.interrupt(); //加不加的效果对比  中断当前线程
    }
}
