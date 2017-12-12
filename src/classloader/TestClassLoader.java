package classloader;

/**
 * Created by lixiangwei2 on 2017/11/1.
 */
public class TestClassLoader {
    public static void main(String[] args) {
        ClassLoader classLoader = TestClassLoader.class.getClassLoader();
        System.out.println(classLoader);
        System.out.println(classLoader.getParent());
        System.out.println(classLoader.getParent().getParent());
        ClassLoader c2 = int.class.getClassLoader();
        System.out.println(c2);
    }
}
