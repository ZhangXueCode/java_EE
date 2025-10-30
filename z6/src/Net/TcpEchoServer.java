package Net;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TcpEchoServer {
    private ServerSocket serverSocket = null;
    public TcpEchoServer(int port) throws IOException {
        serverSocket = new ServerSocket(port);
    }
    public void start() throws IOException {
        System.out.println("服务器启动");
        ExecutorService service = Executors.newCachedThreadPool();
        while (true) {
            //建立连接 内核上已经建立好了 只需要取出到应用程序用就可以了
            Socket clientSocket = serverSocket.accept();
            //创建线程池
            service.submit(new Runnable() {
                @Override
                public void run() {
                    try {
                        processConnection(clientSocket);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
            });

            /*多线程
            Thread t = new Thread(() -> {
                try {
                    processConnection(clientSocket);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });*/
        }
    }

    private void processConnection(Socket clientSocket) throws IOException {
        System.out.printf("[%s:%d] 客户端上线\n",clientSocket.getInetAddress(),clientSocket.getPort());
        //信息交互
        try (InputStream inputStream = clientSocket.getInputStream() ;
             OutputStream outputStream = clientSocket.getOutputStream()) {
            while (true) {
                Scanner scanner = new Scanner(inputStream);
                PrintWriter printWriter = new PrintWriter(outputStream);
                if(!scanner.hasNext()) {
                    System.out.printf("[%s:%d] 客户端下线\n",clientSocket.getInetAddress(),clientSocket.getPort());
                    break;
                }
                //1.解析请求
                String request = scanner.next();
                //2.计算响应
                String response = process(request);
                //3.回复响应
                printWriter.println(response);
                printWriter.flush();
                //4.打印交互过程内容
                System.out.printf("[%s:%d] req = %s res = %s\n",clientSocket.getInetAddress()
                        ,clientSocket.getPort(),request,response);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            clientSocket.close();
        }
    }
    public String process(String request) {
        return request;
    }

    public static void main(String[] args) throws IOException {
        TcpEchoServer tcpEchoServer = new TcpEchoServer(9090);
        tcpEchoServer.start();
    }


}
