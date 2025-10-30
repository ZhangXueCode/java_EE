package Thread;

public class demo5 {
    public static void main(String[] args) {
        Thread thread = new Thread(() ->{
            while (true) {
                System.out.println("hello runnable");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
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
