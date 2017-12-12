package classloader;

import java.lang.reflect.Method;

/**
 * Created by lixiangwei2 on 2017/11/1.
 */
public class ClassLoaderTest {

    public static void main(String[] args) {
        DiskClassLoader diskClassLoader = new DiskClassLoader("D:\\lib");

        Class c = null;
        try {
            c = diskClassLoader.loadClass("classloader.Test");
            if(c != null){
                Object obj = c.newInstance();
                Method method = c.getDeclaredMethod("say",null);
                method.invoke(obj,null);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
