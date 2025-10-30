package Net;

import java.io.IOException;
import java.util.HashMap;

public class TcpDicServer extends TcpEchoServer {
    private HashMap<String,String> map = new HashMap<>();
    public TcpDicServer(int port) throws IOException {
        super(port);
        map.put("cat","小猫");
        map.put("dog","小狗");
        map.put("pig","小猪");
    }
    public String process(String request) {
        return map.getOrDefault(request,"没有这个词");
    }

    public static void main(String[] args) throws IOException {
        TcpDicServer tcpDicServer = new TcpDicServer(9090);
        tcpDicServer.start();
    }
}
