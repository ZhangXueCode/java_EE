package Net;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class UdpEchoServer {
    private DatagramSocket socket = null;
    public UdpEchoServer(int port) throws SocketException {
        socket = new DatagramSocket(port);
    }
    private void start() throws IOException {
        System.out.println("服务器启动");
        while (true) {
            //解析请求并转为字符串
            DatagramPacket requestPacket = new DatagramPacket(new byte[4049],4049);
            socket.receive(requestPacket);
            String request = new String(requestPacket.getData(),0,requestPacket.getLength());
            //计算响应
            String response = process(request);
            //发送响应
            DatagramPacket responsePacket = new DatagramPacket(response.getBytes(),response.getBytes().length
                    ,requestPacket.getSocketAddress());
            socket.send(responsePacket);
            //打印日志
            System.out.printf("[%s : %d] req = %s res = %s\n",requestPacket.getAddress().toString(),
                    requestPacket.getPort(),request,response);

        }
    }
    public String process(String request) {
        return request;
    }

    public static void main(String[] args) throws IOException {
        UdpEchoServer server = new UdpEchoServer(9090);
        server.start();

    }
}
