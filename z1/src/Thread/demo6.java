package Thread;

public class demo6 {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            System.out.print("0 ");
        });
        t1.start();
        Thread t2 = new Thread(() -> {
            System.out.print("1 ");
        });
        t2.start();
        Thread t3 = new Thread(() -> {
            System.out.print("2 ");
        });
        t3.start();
        Thread t4 = new Thread(() -> {
            System.out.print("3 ");
        });
        t4.start();
        Thread t5 = new Thread(() -> {
            System.out.print("4 ");
        });
        t5.start();
        Thread t6 = new Thread(() -> {
            System.out.print("5 ");
        });
        t6.start();
        Thread t7 = new Thread(() -> {
            System.out.print("6 ");
        });
        t7.start();
        Thread t8 = new Thread(() -> {
            System.out.print("7 ");
        });
        t8.start();
        Thread t9 = new Thread(() -> {
            System.out.print("8 ");
        });
        t9.start();
        Thread t10 = new Thread(() -> {
            System.out.print("9 ");
        });
        t10.start();
        Thread t11 = new Thread(() -> {
            System.out.print("10 ");
        });
        t11.start();
        Thread t12 = new Thread(() -> {
            System.out.print("11 ");
        });
        t12.start();
        Thread t13 = new Thread(() -> {
            System.out.print("12 ");
        });
        t13.start();
        Thread t14 = new Thread(() -> {
            System.out.print("13 ");
        });
        t14.start();
        Thread t15 = new Thread(() -> {
            System.out.print("14 ");
        });
        t15.start();
        Thread t16 = new Thread(() -> {
            System.out.print("15 ");
        });
        t16.start();
        Thread t17= new Thread(() -> {
            System.out.print("16 ");
        });
        t17.start();
        Thread t18 = new Thread(() -> {
            System.out.print("17 ");
        });
        t18.start();
        Thread t19 = new Thread(() -> {
            System.out.print("18 ");
        });
        t19.start();
        Thread t20 = new Thread(() -> {
            System.out.println("19 ");
        });
        t20.start();
        t20.join();
        System.out.println("ok");
    }
}
