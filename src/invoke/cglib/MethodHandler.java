package invoke.cglib;


import invoke.InvockCla;
import invoke.InvockClaIn;
import invoke.ProxyTest;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Created by lixiangwei2 on 2017/11/1.
 */
public class MethodHandler implements MethodInterceptor {
    private Object obj;

    public MethodHandler(Object obj) {
        this.obj = obj;
    }

    public Object getProxyObj(){
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(this.obj.getClass());
        // 回调方法
        enhancer.setCallback(this);
        // 创建代理对象
        return enhancer.create();
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("------插入前置通知代码-------------");
        Object rs = method.invoke(obj,objects);
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
