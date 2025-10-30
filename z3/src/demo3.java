import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class demo3 {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 1000; i++) {
            int id = i;
            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    System.out.println(id);
                }
            });
        }
    }
}
