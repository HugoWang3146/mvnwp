package indi.wh.aop;

public class BusinessLogicStaticProxy implements BusinessLogicIF {
	private BusinessLogicIF bl;
	
	public BusinessLogicStaticProxy(BusinessLogicIF bl) {
		this.bl=bl;
	}

	public void doBusinessLogic() {
		before();
		bl.doBusinessLogic();
		after();
	}
	
	private void before() {
		System.out.println("before");
	}

	private void after() {
		System.out.println("after");
	}
	
}
