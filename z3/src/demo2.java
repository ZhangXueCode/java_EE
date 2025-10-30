import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

//线程池案例
class MyThreadPool {
    public BlockingQueue<Runnable> queue = new ArrayBlockingQueue<>(1000);

    public void submit(Runnable runnable) throws InterruptedException {
        queue.put(runnable);
    }
    public MyThreadPool(int n) {
        for (int i = 0; i < n; i++) {
            Thread t = new Thread(() -> {
                while (true) {
                    try {
                        Runnable runnable = queue.take();
                        runnable.run();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }

            });
            t.start();
        }

    }
}
public class demo2 {
    public static void main(String[] args) throws InterruptedException {
        MyThreadPool myThreadPool = new MyThreadPool(4);
        for (int i = 0; i < 1000; i++) {
            int id = i;
            myThreadPool.submit(new Runnable() {
                @Override
                public void run() {
                    System.out.println("执行任务：" + id +"," +Thread.currentThread().getName());
                }
            });
        }

    }
}
