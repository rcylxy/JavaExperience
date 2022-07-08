package cn.itcast.junit;

import java.lang.annotation.ElementType;

/**
 * @Classname DemoReflect
 * @Date 2022/6/29 19:13
 * @Created by 李晓阳
 */
public class DemoReflect {
    public static void main(String[] args) throws Exception {
        Calculator c1 = new Calculator(1, 1, "hello");

        // 通过对象得到Class对象
        Class aClass = c1.getClass();

        // 通过类得到Class对象
        Class bClass = Calculator.class;
        Class objectClass = Object.class;
        Class voidClass = void.class;
        Class aClass1 = int[].class;
        Class comparableClass = Comparable.class;
        Class aClass2 = int[][].class;
        Class elementTypeClass = ElementType.class;
        Class overrideClass = Override.class;
        Class classClass = Class.class;
        // 对于数组，Class对象只与维度有关

        // 通过类的名字与路径得到Class对象
        Class cClass = Class.forName("cn.itcast.junit.Calculator");





        // 基本类型的包装类内置Type方法
        Class dClass = Integer.TYPE;



        // 父类对象getSuperclass

        System.out.println(aClass.hashCode());
        System.out.println(bClass.hashCode());
        System.out.println(cClass.hashCode());
        System.out.println(dClass.hashCode());

    }
}
