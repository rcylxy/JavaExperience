package udp;

import java.io.IOException;
import java.net.*;
import java.nio.charset.StandardCharsets;

/**
 * @Classname udp.SendDemo
 * @Date 2022/7/6 18:54
 * @Created by 李晓阳
 */
public class SendDemo {
    public static void main(String[] args) throws IOException {
        DatagramSocket ds = new DatagramSocket();
        byte[] bys = "hello,UDP!".getBytes();
        DatagramPacket dp = new DatagramPacket(bys, bys.length, InetAddress.getByName("192.168.10.106"), 10086);
        ds.send(dp);
        ds.close();
    }
}
