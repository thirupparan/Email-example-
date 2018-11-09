package com.websystique.spring.configuration;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.websystique.spring.model.CustomerInfo;
import com.websystique.spring.model.ProductOrder;
import com.websystique.spring.service.OrderService;

public class SampleEmailApplication {

	public static void main(String[] args) {
		AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

		OrderService orderService = (OrderService) context.getBean("orderService");
		//orderService.sendOrderConfirmation(getDummyOrder("jerome11hz@gmail.com"));
		orderService.sendOrderConfirmation(getDummyOrder("tmayuran24@gmail.com"));
		//orderService.sendOrderConfirmation(getDummyOrder("anushanth.ramanathan@gmail.com"));
		((AbstractApplicationContext) context).close();
	}
	
	public static ProductOrder getDummyOrder(String email){
		ProductOrder order = new ProductOrder();
		order.setOrderId("SGIC 001");
		order.setProductName("HRM SGIC");
		order.setStatus("confirmed");
		
		CustomerInfo customerInfo = new CustomerInfo();
		customerInfo.setName("mayuran");
		customerInfo.setAddress("SGIC");
		customerInfo.setEmail(email);
		order.setCustomerInfo(customerInfo);
		return order;
	}

}
