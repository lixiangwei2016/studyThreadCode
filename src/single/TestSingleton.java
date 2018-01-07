package single;

import org.junit.Test;

import java.io.*;
import java.lang.reflect.Constructor;

/**
 * 饿汉式，可以避免多线程安全问题
 * Created by Administrator on 2018/1/7.
 */
public class TestSingleton {

    /**
     * 测试饿汉单列模式
     */
    @Test
    public void test(){
        Singleton singleton = Singleton.getSingletonInstance();
        Singleton singleton1 = Singleton.getSingletonInstance();
        if(singleton == singleton1){
            System.out.println("同一个对象");
            System.out.println(singleton);
            System.out.println(singleton1);
        }else{
            System.out.println("不同一个对象");
            System.out.println(singleton);
            System.out.println(singleton1);
        }
    }

    /**
     * 测试懒汉单列模式
     */
    public void test1(){

    }

    @Test
    public void test2(){
        SinletonV3 singleton = SinletonV3.getInstance();
        SinletonV3 singleton1 = SinletonV3.getInstance();
        if(singleton == singleton1){
            System.out.println("同一个对象");
            System.out.println(singleton);
            System.out.println(singleton1);
        }else{
            System.out.println("不同一个对象");
            System.out.println(singleton);
            System.out.println(singleton1);
        }
    }

    /**
     * 通过反射破解单列模式
     */
    @Test
    public void test3() throws Exception {
        Class<Singleton> singletonClass = Singleton.class;
        Constructor<Singleton> c = singletonClass.getDeclaredConstructor();
        c.setAccessible(true);
        Singleton s1= c.newInstance();
        Singleton s2= c.newInstance();
        System.out.println(s1==s2);
        System.out.println(s1);
        System.out.println(s2);


    }

    /**
     * 通过序列化破解单列
     * @throws Exception
     */
    @Test
    public void test4() throws Exception {
        //通过反序列化的方式创建多个对象
        Singleton singleton = Singleton.getSingletonInstance();
        FileOutputStream fos= new FileOutputStream("d:/a.txt");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(singleton);
        oos.close();
        fos.close();
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("d:/a.txt"));
        Singleton s5= (Singleton) ois.readObject();
        System.out.println(s5);
        System.out.println(singleton);




    }

}
