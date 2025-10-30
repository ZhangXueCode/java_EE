import java.util.concurrent.ArrayBlockingQueue;

//阻塞队列案例
class MyBlockingQueue {
    public volatile int head = 0;
    public volatile int tail = 0;
    public volatile int size = 0;
    public volatile String[] tmp = new String[1000];

    public void put(String elem) throws InterruptedException {
        synchronized (this) {
            while (size == tmp.length) {
                this.wait();
            }
            tmp[tail] = elem;
            tail++;
            if(tail == tmp.length) {
                tail = 0;
            }
            size++;
            this.notify();
        }
    }
    public String take() throws InterruptedException {
        synchronized (this) {
            while (size == 0) {
                this.wait();
            }
            String top = tmp[head];
            head++;
            if(head == tmp.length) {
                head = 0;
            }
            size--;
            this.notify();
            return top;
        }
    }

}


public class demo6 {
    public static void main(String[] args) {
        MyBlockingQueue date = new MyBlockingQueue();
        Thread t1 = new Thread(() -> {
            int n = 1;
            while (true) {
                try {
                    date.put(n + "");
                    System.out.println("生产资料：" + n);
                    n++;
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        Thread t2 = new Thread(() -> {
           while (true) {
               try {
                   String a = date.take();
                   System.out.println("消费资料："+ a);
                   //Thread.sleep(400);
               } catch (InterruptedException e) {
                   throw new RuntimeException(e);
               }
           }
        });
        t1.start();
        t2.start();


    }
}
