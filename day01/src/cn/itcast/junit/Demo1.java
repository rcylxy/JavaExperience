package cn.itcast.junit;

import java.lang.reflect.Field;
import java.util.Arrays;

/**
 * @Classname Demo1
 * @Date 2022/6/29 10:08
 * @Created by 李晓阳
 */
public class Demo1 {
    public static void main(String[] args) throws Exception {
        Class<Calculator> calculatorClass = Calculator.class;
        Field[] fields = calculatorClass.getFields();
        // 只能得到public的成员变量，其余三种权限都不行
        System.out.println(Arrays.toString(fields));
        System.out.println();

        Field name = calculatorClass.getDeclaredField("name");


        // 暴力反射，牛啊
//        name.setAccessible(true);

        name.setAccessible(true);


        // 根据类的名字得到某个特定成员变量的Field。

        Calculator c = new Calculator();
        // new出一个新的对象，根据Field来改变其值或者是获取其值。

        name.set(c, "nihao");
        Object o = name.get(c);
        System.out.println(o);

        Field[] declaredFields = calculatorClass.getDeclaredFields();

        System.out.println(Arrays.toString(declaredFields));
    }
}
