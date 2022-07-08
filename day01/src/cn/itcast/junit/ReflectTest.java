package cn.itcast.junit;

import java.io.InputStream;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;
import java.util.Properties;

/**
 * @Classname ReflectTest
 * @Date 2022/6/29 11:41
 * @Created by 李晓阳
 */
@SuppressWarnings("all")
public class ReflectTest {
    @Deprecated
    public void show() {
    }

    @Target(ElementType.TYPE)
    @Retention(RetentionPolicy.RUNTIME)
    protected @interface Mytest {
        String s();
    }

    /**
     * 将Javac编译代码过的产生的字节码文件加载到内存中时产生代表着这个类的Class类的唯一对象
     * (我们所做就是获取这个对象)
     * Java代码实行的过程
     * 1. 加载到内存，每一个类都产生一个对应的Class类，并且实例化产生唯一的对象
     * 2. 链接。为所有static的变量在堆中分配相应的内存，并且初始化为0
     * 3. 初始化。首先执行类构造器的clinit(class init)方法
     * <clinit>(){
     * All Static code         (静态代码块)
     * All Static variables    (静态变量赋值语句)
     * }
     */

    public static void main(String[] args) throws Exception {
        new ReflectTest().show();
        // command + option + V 补全变量

        Properties pro = new Properties();
        // class Properties extends Hashtable<Object,Object>
        // Properties类继承于HashTable，相当于配置文件类，可以读取所有的键值
        // 利用其load方法将文件内容读取

        ClassLoader classLoader = ReflectTest.class.getClassLoader();
        // ReflectTest这个类的字节码文件（.class）的类加载器（.getClassLoader）
        // 作用是将这个类的字节码文件ReflectTest.class加载到内存之中
        // 这种类加载器可以在src之下进行对应的寻找，最终能够找到pro.properties的配置文件

        InputStream is = classLoader.getResourceAsStream(" pro.properties");
        // classLoader中有一个方法getResource可以得到classPath下面的文件的路径
        // 而其中的getResourceAsStream方法可以再找到资源之后按照字符流或者字节流的类型进行返回

        pro.load(is);
        // 使用load方法加载到pro中

        String className = pro.getProperty("className");
        String methodName = pro.getProperty("methodName");
        // 根据键值，得到配置文件的内容，包括全类名和方法名

        Class cls = Class.forName(className);
        // Class是Java反射的源头，是描述某个类的类。对于某个特定的类，
        // JRE都为其保留了一个Class的类，这个类只能实例化一个唯一的对象。
        // 如果实例化多个对象，则他们的HashCode一样。
        // Class类型的对象不能手动创建，只能由系统进行创建。
        // 一个Class对象，就对应着加载到内存中的编译过后的.class文件。
        // Class cls = Class.forName(className);
        // className是一个类的全名（这里指的是Calculator类），cls是描述Calculator类的一个Class类的唯一的对象
        // 而Calculator c1; Class cls = Class.forName(className);
        // cls Calculator c1是一个链式的结构，其中Class.forName指的就是根据类的名字来返回Class的对象
        // 把class利用forName方法加载进内存,利用反射得到对应的
        // 类cls: cls中至少封装了三个部分：Fields(成员变量) Methods(成员方法) Constructors(构造方法)
        // cls可以利用反射机制在运行时获取这个类的所有信息
        /**
         *  cls.getAnnotations();       cls.getDeclaredAnnotations();
         *  cls.getConstructors();      cls.getDeclaredConstructors();
         *  cls.getFields();            cls.getDeclaredFields();
         *  cls.getMethods();           cls.getDeclaredMethods();
         */

        // 如果是私有的属性，无法直接通过反射得到其对象，那我们就需要给予访问权限。
        cls.getConstructor().setAccessible(true);
        // 这一句代码很重要，被称作是：暴力反射


        /**
         *  Constructor constructor = cls.getConstructor();
         *  constructor.setAccessible(true);
         *  Object o1 = constructor.newInstance(1, 1, "nihao");
         *  Calculator o2 = (Calculator) o1;
         */


        Object o = cls.newInstance();
        // 得到对应的类cls之后，利用其无参构造方法cls.newInstance()，这个实质上等同于new，但是效率较低
        // 创建一个对象o，这个对象就是
        // 全类名所代指的类 加载到内存之后产生的类 的实例化的对象 Object o

        Method method = cls.getMethod(methodName);
        // Object o中存在封装好的method，利用加载类的getMethod方法
        // 得到封装好的Method类，并进行实体化，创建了method对象

        method.invoke(o);
        // method对象之中由实行方法的方法invoke，传入的是对象，如果有参数则也要传入相对应的参数列表
    }
}
