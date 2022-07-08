package http;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

/**
 * @Classname ClientDemo
 * @Date 2022/7/6 19:27
 * @Created by 李晓阳
 */
public class ClientDemo {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("192.168.10.106", 10001);
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("hello,http,i'm coming".getBytes(StandardCharsets.UTF_8));
        socket.close();
    }
}
