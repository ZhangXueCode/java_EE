import java.io.*;
import java.util.Scanner;

//复制文件
public class demo2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入路径");
        String a = scanner.next();
        File scr = new File(a);
        if(!scr.exists()) {
            System.out.println("文件不存在");
            return;
        }
        if(!scr.isFile()) {
            System.out.println("不是文件");
            return;
        }
        System.out.println("请输入目标文件路径");
        String b = scanner.next();
        File des = new File(b);
        if(des.exists()) {
            if(des.isDirectory()) {
                System.out.println("这是目录");
                return;
            }
            if(des.isFile()) {
                System.out.println("确定吗（y/n）");
                String c = scanner.next();
                if(!c.toLowerCase().equals("y")) {
                    System.out.println("不复制");
                    return;
                }
                try (InputStream inputStream = new FileInputStream(scr)) {
                    try (OutputStream outputStream = new FileOutputStream(des)) {
                        byte[] buf = new byte[1024];
                        int n = 0;
                        while (true) {
                            n = inputStream.read(buf);
                            if(n == -1) {
                                break;
                            }
                            outputStream.write(buf);
                        }
                        outputStream.flush();
                    }
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("复制完成");

            }
        }

    }
}
