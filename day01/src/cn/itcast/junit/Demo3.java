package cn.itcast.junit;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @Classname Demo3
 * @Date 2022/6/29 11:13
 * @Created by 李晓阳
 */
public class Demo3 {
    public static void main(String[] args) {
        Class<Calculator> calculatorClass = Calculator.class;
//        try {
//            Method eatMethod = calculatorClass.getMethod("add", int.class, int.class);
//            Calculator c = new Calculator();
//            eatMethod.invoke(c, 1, 2);
        try {
            Method m1 = calculatorClass.getMethod("add", int.class, int.class);
            m1.setAccessible(true);
            System.out.println(m1.getName());
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        for (Method declaredMethod : calculatorClass.getMethods()) {
            System.out.println(declaredMethod);
        }

//        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
//            e.printStackTrace();
//        }
    }
}
