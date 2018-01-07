package single;

/**
 * 懒汉式,在需要的时候才去创建
 * Created by Administrator on 2018/1/7.
 */
public class SingletonV2 {
    private static SingletonV2 singleton =null;
    private SingletonV2(){}
    public static SingletonV2 getSingletonInstance(){
        if(singleton == null){
            singleton = new SingletonV2();
        }
        return singleton;
    }
}
