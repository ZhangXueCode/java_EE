public class demo2 {
    public static void main(String[] args) throws InterruptedException {
        Object lock = new Object();
        for (int i = 0; i < 10; i++) {
            Thread t1 = new Thread(() -> {
                synchronized (lock) {
                    System.out.print("A");
                }
            });
            Thread t2 = new Thread(() -> {
                try {
                    t1.join();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                synchronized (lock) {
                    System.out.print("B");
                }
            });
            Thread t3 = new Thread(() -> {
                try {
                    t2.join();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                synchronized (lock) {
                    System.out.print("C");
                }

            });
            t1.start();
            t2.start();
            t3.start();
            t1.join();
            t2.join();
            t3.join();
            System.out.println();
        }
    }
}
