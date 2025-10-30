import java.util.concurrent.*;

public class demo4 {
    public static void main(String[] args) {
        ExecutorService pool = new ThreadPoolExecutor(5, 10, 1000,
                TimeUnit.MILLISECONDS, new ArrayBlockingQueue<>(100), new ThreadPoolExecutor.DiscardPolicy());
        for (int i = 0; i < 2000; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + "执行完");
            },"Thread-" + (i+1)).start();

        }
    }
}
