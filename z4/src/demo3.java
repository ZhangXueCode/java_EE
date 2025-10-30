import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

public class demo3 {
    public static int count = 0;
    public static void main(String[] args) throws InterruptedException {
        Semaphore semaphore = new Semaphore(1);
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 50; i++) {
                try {
                    semaphore.acquire();
                    count++;
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } finally {
                    semaphore.release();
                }
            }
        });
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 50; i++) {
                try {
                    semaphore.acquire();
                    count++;
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } finally {
                    semaphore.release();
                }
            }
        });
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(count);

    }
}
