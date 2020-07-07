package carry.分布式专题.第一讲分布式的发展与演进.案例.Sync;

public class Synchronized {

    // 同步方法
   public synchronized  void sync() {
       System.out.println("hahahahahaa");
   }

   // 同步代码块
    public void sync1() {
       synchronized (Synchronized.class) {

       }
    }
}
