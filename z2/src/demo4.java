public class demo4 {
    public static void main(String[] args) {
        Thread c = new Thread(() -> {
            System.out.println("c");
        });
        Thread b = new Thread(() -> {
            try {
                c.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("b");
        });
        Thread a = new Thread(() -> {
            try {
                c.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            try {
                b.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("a");
        });

        a.start();
        b.start();
        c.start();
    }
}
