package carry.分布式专题.第一讲分布式的发展与演进.案例.Interrupt;

import java.util.concurrent.TimeUnit;

public class InterruptDemo2 {

    private static int i = 0;

    public static void main(String[] args) throws InterruptedException {


        Thread thread = new Thread(() -> {
            while (!Thread.currentThread().isInterrupted()) {
                try {
                    i++;
                    System.out.println("before: "+Thread.currentThread().isInterrupted());
                    TimeUnit.SECONDS.sleep(2);
                    System.out.println("异常还能运行吗?");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    //想要结束的话，可以再异常里面处理
                    break; //加不加的效果
                }
            }
            System.out.println("i:" + i);
        }, " InterruptDemo");
        thread.start();
        TimeUnit.SECONDS.sleep(1);
        thread.interrupt(); //加不加的效果对比  中断当前线程
    }
}
