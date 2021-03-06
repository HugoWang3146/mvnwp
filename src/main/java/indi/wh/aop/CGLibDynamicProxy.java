package indi.wh.aop;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class CGLibDynamicProxy implements MethodInterceptor {
	 
    private static CGLibDynamicProxy instance = new CGLibDynamicProxy();
 
    private CGLibDynamicProxy() {
    }
 
    public static CGLibDynamicProxy getInstance() {
        return instance;
    }
 
    @SuppressWarnings("unchecked")
    public <T> T getProxy(Class<T> cls) {
        return (T) Enhancer.create(cls, this);
    }
 
    public Object intercept(Object target, Method method, Object[] args, MethodProxy proxy)
    		throws Throwable {
        before();
        Object result = proxy.invokeSuper(target, args);
        after();
        return result;
    }
 
    private void before() {
        System.out.println("before");
    }
 
    private void after() {
        System.out.println("after");
    }
}
