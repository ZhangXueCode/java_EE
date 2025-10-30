package Net;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.SplittableRandom;

public class TcpEchoClient {
    private Socket socket = null;
    public TcpEchoClient(String ip,int port) throws IOException {
        socket = new Socket(ip,port);
    }
    public void start() throws IOException {
        System.out.println("客户端启动");
        Scanner scanner = new Scanner(System.in);
        try (InputStream inputStream = socket.getInputStream();
             OutputStream outputStream = socket.getOutputStream()) {
            while (true) {
                //1.写需求
                PrintWriter printWriter = new PrintWriter(outputStream);
                //2.读响应
                Scanner scannerWork = new Scanner(inputStream);
                System.out.print("->");
                //发送请求
                String request = scanner.next();
                printWriter.println(request);
                printWriter.flush();
                //读响应
                String response = scannerWork.next();
                System.out.println(response);

            }
        }
    }

    public static void main(String[] args) throws IOException {
        TcpEchoClient tcpEchoClient = new TcpEchoClient("127.0.0.1",9090);
        tcpEchoClient.start();
    }
}
