package carry.高并发专题.第三讲AQS原理分析.案例;

public class InterruptDemo {

    public static void main(String[] args) {

        Thread thread = new Thread(new Thread2());
        thread.start();
    }
}



class Thread2 implements  Runnable{

    @Override
    public void run() {
        try {
            System.out.println();
            System.out.println(Thread.currentThread().isInterrupted());//输出false
            Thread.currentThread().interrupt();//当前线程中断
            System.out.println(Thread.currentThread().isInterrupted());//输出true
                    Thread.sleep(3000);//中断后执行sleep会抛出异常
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.out.println(Thread.currentThread().isInterrupted());//输出false
        }

    }
}