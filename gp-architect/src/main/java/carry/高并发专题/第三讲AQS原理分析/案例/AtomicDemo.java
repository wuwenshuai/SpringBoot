package carry.高并发专题.第三讲AQS原理分析.案例;

import sun.plugin.ClassLoaderInfo;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 使用lock，实现100个线程i++的操作
 */
public class AtomicDemo {

    private static int count = 0;

    private static Lock lock = new ReentrantLock();

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 100; i++) {
            new Thread(() -> AtomicDemo.addCount()).start();
        }
        Thread.sleep(3000);
        System.out.println("count:" + count);
    }

    public static void addCount() {
        try {
            lock.lock(); //获得锁
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            count++;
        } finally {
            lock.unlock();
        }

    }
}


