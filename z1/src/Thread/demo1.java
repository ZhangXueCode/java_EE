package Thread;
class MyThread extends Thread {
    @Override
    public void run() {
        while(true) {
            System.out.println("hello Thread");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
public class demo1 {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new MyThread();
        t.start();
        while (true) {
            System.out.println("hello main");
            Thread.sleep(1000);
        }

    }

}
