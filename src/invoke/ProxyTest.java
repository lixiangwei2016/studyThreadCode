package invoke;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by lixiangwei2 on 2017/11/1.
 */
public class ProxyTest implements InvocationHandler {
    private Object obj;

    public ProxyTest(Object obj) {
        this.obj = obj;
    }

    public Object getProxyObj(){
        return Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(),obj.getClass().getInterfaces(),this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("------插入前置通知代码-------------");
        Object rs = method.invoke(obj,args);
        System.out.println("------插入后置处理代码-------------");
        return rs;
    }

}

class Test{
    public static void main(String[] args) {
        InvockClaIn inv = new InvockCla();
        ProxyTest proxyTest = new ProxyTest(inv);
        InvockClaIn in = (InvockClaIn) proxyTest.getProxyObj();
        in.queryInfo();
    }
}