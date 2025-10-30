public class demo1 {
    public static int count = 0;
    public static void main(String[] args) throws InterruptedException {
        Object lock = new Object();
        Thread t = new Thread(() -> {
            synchronized (lock) {
                for (int i = 0; i < 10000; i++) {
                    count++;
                }
            }
        });
        Thread t2 = new Thread(() -> {
            synchronized (lock) {
                for (int i = 0; i < 10000; i++) {
                    count++;
                }
            }
        });
        t.start();
        t2.start();
        t.join();
        t2.join();
        System.out.println(count);
    }
}
