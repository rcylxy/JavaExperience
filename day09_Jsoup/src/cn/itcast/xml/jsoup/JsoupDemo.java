package cn.itcast.xml.jsoup;

import cn.wanghaomiao.xpath.exception.XpathSyntaxErrorException;
import cn.wanghaomiao.xpath.model.JXDocument;
import cn.wanghaomiao.xpath.model.JXNode;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * @Classname JsoupDemo
 * @Date 2022/7/3 1:35
 * @Created by 李晓阳
 */
public class JsoupDemo {
    public static void main(String[] args) throws IOException, XpathSyntaxErrorException {
        String path = JsoupDemo.class.getClassLoader().getResource("student.xml").getPath();
        Document document = Jsoup.parse(new File(path), "utf-8");
//        Elements elements = document.getElementsByTag("name");
//        System.out.println(elements.size());
//
//        Element element = elements.get(0);
//        System.out.println(element.text());
//        Element ele = document.getElementsByTag("name").get(0);
//        System.out.println(ele.html());
        JXDocument jxDocument = new JXDocument(document);
        List<JXNode> jxNodes = jxDocument.selN("//student/name[@id]");
        for (JXNode jxNode : jxNodes) {
            System.out.println(jxNode);
            System.out.println("--------------------------");
        }

    }
}
