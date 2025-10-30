import java.util.PriorityQueue;

//定时器
class MyTimerTask implements Comparable<MyTimerTask>{
    public Runnable runnable;
    public long time;
    public Runnable getRunnable() {
        return runnable;
    }
    public long getTime() {
        return time;
    }
    public MyTimerTask(Runnable runnable,long delay) {
        this.runnable = runnable;
        this.time = System.currentTimeMillis() + delay;
    }

    @Override
    public int compareTo(MyTimerTask o) {
        return (int) (this.time - o.time);
    }
}
class MyTimer {
    public PriorityQueue<MyTimerTask> queue = new PriorityQueue<>();
    public Object lock = new Object();
    public void schedule(Runnable runnable,long delay) {
        synchronized (lock) {
            queue.offer(new MyTimerTask(runnable,delay));
            lock.notify();
        }
    }
    public MyTimer() {
        Thread t = new Thread(() -> {
            while (true) {
                try {
                    synchronized (lock) {
                        while (queue.isEmpty()) {
                            lock.wait();
                        }
                        MyTimerTask task = queue.peek();
                        long curTime = System.currentTimeMillis();
                        if (curTime >= task.getTime()) {
                            task.getRunnable().run();
                            queue.poll();
                        } else {
                            lock.wait(task.getTime() - curTime);
                        }
                    }
                } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                  }
            }
        });
        t.start();
    }

}
public class demo1 {
    public static void main(String[] args) {
        MyTimer timer = new MyTimer();
        timer.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println("3000");
            }
        },3000);
    }

}
