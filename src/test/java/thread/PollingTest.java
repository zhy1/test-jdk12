package thread;
import org.junit.Test;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PollingTest {

    ExecutorService fixedPool;

    class MyThread03 implements Runnable {
        @Override
        public void run() {
            try {
                Thread.sleep(1);
                System.out.println(System.currentTimeMillis());
                throw new  Exception("");
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            fixedPool.execute(new MyThread03());
        }
    }

    public void thread() {
        fixedPool = Executors.newFixedThreadPool(1);
    }

    public void addThread() {
        fixedPool.execute(new MyThread03());
    }

    @Test
    public void TestThread() {
        PollingTest a = new PollingTest();
        a.thread();
        a.addThread();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
