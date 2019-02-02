package indi.wh.spring.aspect.service;

import org.springframework.stereotype.Service;

@Service
public class BusinessLogicServiceImpl implements BusinessLogicServiceIF{

	public void doBusinessLogic() {
		System.out.println("do business logic");
	}
	
}
