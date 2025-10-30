package Thread;

class MyRunnable implements Runnable {
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
}
public class demo2 {
    public static void main(String[] args) {
        Runnable runnable = new MyRunnable();
        Thread thread = new Thread(runnable);
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
