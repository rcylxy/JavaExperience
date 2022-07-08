package cn.itcast.junit;

import java.lang.reflect.Constructor;

/**
 * @Classname Demo2
 * @Date 2022/6/29 10:55
 * @Created by 李晓阳
 */
public class Demo2 {
    public static void main(String[] args) throws Exception {
        Class<Calculator> calculatorClass = Calculator.class;
        Constructor<Calculator> constructor = calculatorClass.getConstructor(int.class, long.class, String.class);
        System.out.println(constructor);
        // 用下面这个方法来创建对象
        Calculator obj1 = constructor.newInstance(1, 1, "hello");
        System.out.println(obj1.hashCode());
//        Calculator obj2 = constructor.newInstance();
//        System.out.println(obj2.hashCode());
        Calculator ong = calculatorClass.newInstance();
        System.out.println(ong);
//        constructor.setAccessible(true);
        constructor.setAccessible(true);
    }
}
