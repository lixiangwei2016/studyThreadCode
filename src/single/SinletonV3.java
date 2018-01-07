package single;

/**
 * Created by Administrator on 2018/1/7.
 */
public class SinletonV3 {
    private static class SingleInner{
        private static SinletonV3 sinletonV3 = new SinletonV3();
    }
    private SinletonV3(){}

    public static SinletonV3 getInstance(){
        return SingleInner.sinletonV3;
    }
}
