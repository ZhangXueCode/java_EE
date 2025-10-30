package Net;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.HashMap;

public class UdpDicServer {
    private DatagramSocket socket = null;
    private HashMap<String,String> map = new HashMap();
    public UdpDicServer(int port) throws SocketException {
        socket = new DatagramSocket(port);
        map.put("cat","小猫");
        map.put("dog","小狗");
        map.put("pig","小猪");
    }
    public void start() throws IOException {
        while (true) {
            System.out.println("服务器启动");
            DatagramPacket requestPacket = new DatagramPacket(new byte[4090],4090);
            socket.receive(requestPacket);
            String request = new String(requestPacket.getData(),0, requestPacket.getLength());

            String response = process(request);

            DatagramPacket responsePacket = new DatagramPacket(response.getBytes(),response.getBytes().length
                    ,requestPacket.getSocketAddress());
            socket.send(responsePacket);

            System.out.printf("[%s:%d] req=%s res=%s\n",responsePacket.getAddress(),responsePacket.getPort()
                    ,request,response);


        }

    }
    public String process(String request) {
        return map.getOrDefault(request,"没有这样的词");
    }

    public static void main(String[] args) throws IOException {
        UdpDicServer udpDicServer = new UdpDicServer(9090);
        udpDicServer.start();
    }


}
