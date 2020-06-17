package carry.分布式专题.第一讲分布式的发展与演进.案例.创造线程的几种方式;


import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * 创建线程的几种方式： 1.继承Thread 2.实现Runnable接口 3.实现Callable接口
 */
public class ThreadDemo {
    public static void main(String[] args) throws Exception{


        //方式1：
        ThreadExtendThread threadExtendThread = new ThreadExtendThread();
        threadExtendThread.start();

        //方式2
        ThreadImp threadImp = new ThreadImp();
        Thread thread = new Thread(threadImp);
        thread.start();

        //方式3
        ExecutorService threadPool = Executors.newFixedThreadPool(1);
        Future submit = threadPool.submit(new ThreadImpCallable());
        submit.get();
        threadPool.shutdown();


    }

}


//方式1

class ThreadExtendThread extends Thread {
    @Override
    public void run() {

        System.out.println("ThreadExtendThread run");
    }
}

// 方式2：

class ThreadImp implements Runnable {

    public void run() {
        System.out.println("ThreadImp run");
    }
}

//方式三

class ThreadImpCallable implements Callable {

    public Object call() throws Exception {
        System.out.println("ThreadImpCallable run");
        return null;
    }
}
