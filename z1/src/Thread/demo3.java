package Thread;

public class demo3 {
    public static void main(String[] args) {
        Thread thread = new Thread() {
            @Override
            public void run() {
                while (true) {
                    System.out.println("hello runnable");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        };
        thread.start();
        while (true) {
            System.out.println("hello main");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
