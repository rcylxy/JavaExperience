package udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * @Classname udp.ReceiveDemo
 * @Date 2022/7/6 19:12
 * @Created by 李晓阳
 */
public class ReceiveDemo {
    public static void main(String[] args) throws IOException {
        DatagramSocket ds = new DatagramSocket(10086);
        byte[] bys = new byte[1024];
        DatagramPacket dp = new DatagramPacket(bys, bys.length);
        ds.receive(dp);
        byte[] datas = dp.getData();
        int len = dp.getLength();
        String datasString = new String(datas, 0, len);
        System.out.println(datasString);
        ds.close();

    }


}
