package carry.分布式专题.第一讲分布式的发展与演进.案例.Condition;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class ConditionDemoSingle implements Runnable{

    private Lock lock;
    private Condition condition;

    public ConditionDemoSingle(Lock lock, Condition condition) {
        this.lock = lock;
        this.condition = condition;
    }

    @Override
    public void run() {

        System.out.println("ConditionDemoSingle  begin");
        try {
            lock.lock();
            condition.signal();
            System.out.println("ConditionDemoSingle  end");
        } finally {
            lock.unlock();
        }
    }
}
