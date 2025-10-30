import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class demo6 {
    public static void main(String[] args) {
        ExecutorService service = Executors.newSingleThreadExecutor();
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
