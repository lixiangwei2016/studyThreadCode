package single;

import java.io.Serializable;

/**
 * 饿汉式，可以避免多线程安全问题
 * Created by Administrator on 2018/1/7.
 */
public class Singleton implements Serializable{
    private static transient Singleton singletonInstance = new Singleton();

    private Singleton(){}

    public static Singleton getSingletonInstance(){
        return singletonInstance;
    }

    private Object readResolve(){
        return singletonInstance;
    }

}
