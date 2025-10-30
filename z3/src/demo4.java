import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class demo4 {
    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(4);
        for (int i = 0; i < 1000; i++) {
            int id = i;
            service.submit(new Runnable() {
                @Override
                public void run() {
                    System.out.println(id);
                }
            });
        }
    }
}
