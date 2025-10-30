public class demo3 {
    //死锁
    public static void main(String[] args) {
        Object lock1 = new Object();
        Object lock2 = new Object();
        Thread t1 = new Thread(() -> {
            synchronized(lock1) {
                //此时休眠是很重要的，使两个线程各自有一把琐，避免t1过快的操作完了
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                synchronized (lock2) {
                    System.out.println("锁1成功");
                }
            }

        });
        Thread t2 = new Thread(() -> {
            synchronized(lock2) {
                synchronized (lock1) {
                    System.out.println("锁2成功");
                }
            }

        });
        t1.start();
        t2.start();
    }

}
