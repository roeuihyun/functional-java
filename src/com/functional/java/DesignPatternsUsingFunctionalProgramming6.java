package com.functional.java;

import java.math.BigDecimal;
import java.util.Arrays;

import com.functional.java.model.Order;
import com.functional.java.model.Order.OrderStatus;
import com.functional.java.model.OrderLine;
import com.functional.java.service.OrderProcessStep;

public class DesignPatternsUsingFunctionalProgramming6 {
	
	// 생성 패턴 (Creational Patterns) - 오브젝트의 생성에 관련된 패턴
	// 구조 패턴 (Strutural Patterns) - 상속을 이용해 클래스/오브젝트를 조합하여 더 발전된 구조로 만드는 패턴
	// 행동 패턴 (Behavioral Patterns) - 필요한 작업을 여러 객체를 분해하여 객체간 결합도를 줄이게 해주는 패턴
	
	// Chain of Responsibility Pattern
	public static void main(String[] args) {
		
		OrderProcessStep initializeStep = new OrderProcessStep(order -> {
			if(order.getStatus() == OrderStatus.CREATED) {
				System.out.println("Start Processing order " + order.getId());
				order.setStatus(OrderStatus.IN_PROGRESS);
			}
		});
		
		OrderProcessStep setOrderAmountStep = new OrderProcessStep(order -> {
			if(order.getStatus() == OrderStatus.IN_PROGRESS) {
				System.out.println("Setting Amount of order " + order.getId());
				order.setAmount(order.getOrderLines().stream()
						.map(orderline -> orderline.getAmount())
						.reduce(BigDecimal.ZERO,(x,y) -> x.add(y))
						);
			}
		});
		
		OrderProcessStep verifyOrderStep = new OrderProcessStep(order -> {
			if(order.getStatus() == OrderStatus.IN_PROGRESS) {
				System.out.println("Verifying order " + order.getId());
				if(order.getAmount().compareTo(BigDecimal.ZERO) < 0) {
					order.setStatus(OrderStatus.ERROR);
				}
			}
		});
		
		OrderProcessStep processPaymentStep = new OrderProcessStep(order -> {
			if(order.getStatus() == OrderStatus.IN_PROGRESS) {
				System.out.println("Processing payment of order " + order.getId());
				order.setStatus(OrderStatus.PROCESSED);
			}
		});
		
		
		OrderProcessStep handleErrorStep = new OrderProcessStep(order -> {
			if(order.getStatus() == OrderStatus.ERROR) {
				System.out.println("Sending out Failed to process order alert for order " + order.getId());
			}
		});
		
		OrderProcessStep completeProcessingOrderStep = new OrderProcessStep(order -> {
			if(order.getStatus() == OrderStatus.PROCESSED) {
				System.out.println("Finished processing order " + order.getId());
			}
		});
		
		OrderProcessStep chainedOrderProcessSteps = initializeStep
				.setNext(setOrderAmountStep)
				.setNext(verifyOrderStep)
				.setNext(processPaymentStep)
				.setNext(handleErrorStep)
				.setNext(completeProcessingOrderStep);
		
		Order order1 = new Order()
				.setId(1001L)
				.setStatus(OrderStatus.CREATED)
				.setOrderLines(Arrays.asList(
						new OrderLine().setAmount(BigDecimal.valueOf(1000)),
						new OrderLine().setAmount(BigDecimal.valueOf(2000))
						));
		
		chainedOrderProcessSteps.process(order1);
		
		Order order2 = new Order()
				.setId(1001L)
				.setStatus(OrderStatus.CREATED)
				.setOrderLines(Arrays.asList(
						new OrderLine().setAmount(BigDecimal.valueOf(1000)),
						new OrderLine().setAmount(BigDecimal.valueOf(-2000))
						));
		
		chainedOrderProcessSteps.process(order2);
	}

}
