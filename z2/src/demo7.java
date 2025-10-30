import java.util.PriorityQueue;

//定时器
//1.创建一个类 包含任务与时间
//2.创建一个数据结构 记录所有任务与时间
//3.创建“扫描线程” 判断是否执行任务
class MyTimerTask implements Comparable<MyTimerTask> {
    public Runnable runnable;
    public long time;
    public MyTimerTask(Runnable runnable,long delay) {
        this.runnable = runnable;
        this.time = System.currentTimeMillis() + delay;
    }

    public Runnable getRunnable() {
        return runnable;
    }
    public long getTime() {
        return time;
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
                try{
                    synchronized (lock) {
                        while (queue.isEmpty()) {
                            lock.wait();
                        }
                        long curTime = System.currentTimeMillis();
                        MyTimerTask task = queue.peek();
                        if(curTime>= task.getTime()) {
                            task.getRunnable().run();
                            queue.poll();
                        }else {
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
public class demo7 {
    public static void main(String[] args) {
        MyTimer timer = new MyTimer();
        timer.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println("3000");
            }
        },3000);
        timer.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println("2000");
            }
        },2000);
        timer.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println("1000");
            }
        },1000);
        System.out.println("程序启动");

    }
}
