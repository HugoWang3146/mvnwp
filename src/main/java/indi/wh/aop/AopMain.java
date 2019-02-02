package indi.wh.aop;

import net.sf.cglib.core.DebuggingClassWriter;

public class AopMain {

  public static void main(String[] args) {
    aop();
    aopStaticProxy();

    aopJDKDynamicProxy();
    aopCGLibDynamicProxy();

  }

  public static void aop() {
    BusinessLogicIF bl = new BusinessLogicImpl();
    bl.doBusinessLogic();
    System.out.println(bl.getClass());
  }

  public static void aopStaticProxy() {
    BusinessLogicStaticProxy blp = new BusinessLogicStaticProxy(new BusinessLogicImpl());
    blp.doBusinessLogic();
    System.out.println(blp.getClass());
  }

  public static void aopJDKDynamicProxy() {
    BusinessLogicIF jdp = new JDKDynamicProxy(new BusinessLogicImpl()).getProxy();
    jdp.doBusinessLogic();
    System.out.println(jdp.getClass());
    try {
      ProxyUtils.generateClassFile(BusinessLogicIF.class, "JDKDynamicProxyCode");
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public static void aopCGLibDynamicProxy() {
    System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY,
        "D:\\\\Repository\\\\BackEnd\\\\mvnp\\\\target\\\\classes");
    BusinessLogicImpl cdp = CGLibDynamicProxy.getInstance().getProxy(BusinessLogicImpl.class);
    cdp.doBusinessLogic();
    System.out.println(cdp.getClass());
  }

}
