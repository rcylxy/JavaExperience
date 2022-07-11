package web.response.request;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

/**
 * @Classname request.TestDemo1
 * @Date 2022/7/9 12:40
 * @Created by 李晓阳
 */
public class TestDemo1 {
    public static void main(String[] args) throws UnsupportedEncodingException {
        String s = "李晓阳";

        String encode = URLEncoder.encode(s, "utf-8");
        System.out.println(encode);

        String decode = URLDecoder.decode(encode, "ISO-8859-1");
        System.out.println(decode);

        System.out.println(URLDecoder.decode(URLEncoder.encode(decode, "ISO-8859-1"),"utf-8"));

        byte[] bytes = decode.getBytes(StandardCharsets.ISO_8859_1);
        /*
        for (byte aByte : bytes) {
            System.out.print(aByte);
        }
        */
        String s1=new String(bytes,"utf-8");
        System.out.println();
        System.out.println(s1);


    }
}
