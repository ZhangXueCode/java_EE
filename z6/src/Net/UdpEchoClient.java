package Net;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.Scanner;

public class UdpEchoClient {
    private DatagramSocket socket = null;
    public String ip;
    public int port;
    public UdpEchoClient(String ip,int port) throws SocketException {
        this.ip = ip;
        this.port = port;
        socket = new DatagramSocket();
    }
    public void start() throws IOException {
        System.out.println("客户端启动");
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("->");
            String request = scanner.next();
            //发送请求
            DatagramPacket requestPacket = new DatagramPacket(request.getBytes(),request.getBytes().length,
                    InetAddress.getByName(ip),port);
            socket.send(requestPacket);
            //接收响应
            DatagramPacket responsePacket = new DatagramPacket(new byte[4049],4049);
            socket.receive(responsePacket);
            String response = new String(responsePacket.getData(),0,responsePacket.getLength());
            System.out.println(response);

        }
    }

    public static void main(String[] args) throws IOException {
        UdpEchoClient client = new UdpEchoClient("127.0.0.1",9090);
        client.start();
    }

}
