package cn.itcast.junit;

import org.junit.*;

/**
 * @Classname Test01
 * @Date 2022/6/29 1:09
 * @Created by 李晓阳
 */
public class test01 {
    @Before
    public void testBefore(){
        System.out.println('1');
    }


    @Test
    public void test(){
        System.out.println('d');
    }

    @After
    public void testAfter(){
        System.out.println('2');
    }

}
