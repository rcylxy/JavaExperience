package http;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Classname ServerDemo
 * @Date 2022/7/6 19:40
 * @Created by 李晓阳
 */
public class ServerDemo {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(10001);
        Socket accept = ss.accept();
        InputStream inputStream = accept.getInputStream();
        byte[] bys = new byte[1024];
        int len = inputStream.read(bys);
        String s = new String(bys, 0, len);
        System.out.println(s);
        accept.close();
        ss.close();


    }
}
