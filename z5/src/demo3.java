import java.io.*;
import java.util.Scanner;

public class demo3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入要扫描的路径：");
        String path = scanner.next();
        File rootPath = new File(path);
        if(!rootPath.isDirectory()) {
            System.out.println("输入错误");
            return;
        }
        System.out.println("请输入查找的关键词：");
        String word = scanner.next();
        ScanDir(rootPath,word);
    }
    private static void ScanDir(File rootPath, String word) {
        File[] files = rootPath.listFiles();
        if(files == null) {
            return;
        }
        for(File f : files) {
            System.out.println("当前扫描的文件是：" + f.getAbsolutePath());
            if(f.isFile()) {
                check(f,word);
            }else {
                ScanDir(f,word);
            }
        }
    }
    private static void check(File f,String word) {
        try (InputStream is = new FileInputStream(f)) {
            String charset = "UTF-8";
            byte[] bytes = new byte[1024];
            while (true) {
                int n = is.read(bytes);
                if(n == -1) {
                    break;
                }
                String file = new String(bytes,charset);
                if(!file.contains(word) && !f.getName().contains(word)) {
                    return;
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("当前文件为：" + f.getAbsolutePath() + "是否删除（y/n）");
        Scanner scanner = new Scanner(System.in);
        String choice = scanner.next();
        if(!choice.toLowerCase().equals("y")) {
            System.out.println("不删除");
        }else {
            f.delete();
            System.out.println("删除成功");
        }

    }
}
