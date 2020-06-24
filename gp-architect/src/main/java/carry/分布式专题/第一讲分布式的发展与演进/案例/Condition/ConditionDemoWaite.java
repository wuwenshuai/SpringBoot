package carry.分布式专题.第一讲分布式的发展与演进.案例.Condition;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class ConditionDemoWaite implements Runnable{

    private Lock lock;
    private Condition condition;

    public ConditionDemoWaite(Lock lock, Condition condition) {
        this.lock = lock;
        this.condition = condition;
    }

    @Override
    public void run() {

        System.out.println("ConditionDemoWaite  begin");
        try {
            lock.lock();
            condition.await();
            System.out.println("ConditionDemoWaite  end");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
