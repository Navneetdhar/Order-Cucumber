//package com.rvy.controller;
//
//import static org.assertj.core.api.Assertions.assertThat;
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
//import java.time.LocalDate;
//
//import java.util.Arrays;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
//import org.springframework.boot.test.web.client.TestRestTemplate;
//import org.springframework.boot.web.server.LocalServerPort;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit.jupiter.SpringExtension;
//
//
//import com.rvy.SupermarketAppOrderManagementServiceApplication;
//import com.rvy.entity.OrderDetail;
//import com.rvy.entity.OrderMaster;
//import com.rvy.payload.request.OrderRequest;
//import com.rvy.payload.response.MessageResponse;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@ExtendWith(SpringExtension.class)
//@ContextConfiguration(classes = TestConfig.class)
//@SpringBootTest(classes = SupermarketAppOrderManagementServiceApplication.class,webEnvironment = WebEnvironment.RANDOM_PORT)
//public class OrderControllerIntegrationTest {
//
//	@Autowired
//	TestRestTemplate restTemplate;
//	
//	@LocalServerPort
//	Integer port;
//	
//	//List<OrderDetail> orderDetailList;
//	@Test
//	public void testOrderMaster()
//	{
//		OrderDetail orderDetail1 = new OrderDetail(null,5,22.0,110.0,23);
//		OrderDetail orderDetail2 = new OrderDetail(null,5,22.0,110.0,23);
//		List<OrderDetail>  orderDetailList = Arrays.asList(orderDetail1,orderDetail2);
//		OrderRequest orderRequest = new OrderRequest(null,LocalDate.of(2021, 4, 21),1400.00,180.45,
//													1500.00,"DEBIT","INR",123,3,orderDetailList);
//		System.out.println(port);
//		//ResponseEntity<Customer> result = restTemplate.postForEntity("http://localhost:"+port.toString()+"/rvy/api/cm/v1/customers", customer, Customer.class);
//		ResponseEntity<MessageResponse> result = restTemplate.postForEntity("http://localhost:"+port.toString()+"/rvy/api/oms/v1/orders", orderRequest, MessageResponse.class);
//		//System.out.println(result.getBody().getOrderAmount());
//		assertEquals(result.getStatusCode(),HttpStatus.OK);
//		restTemplate.delete("http://localhost:"+port.toString()+"/rvy/api/oms/v1/orders/"+result.getBody().getOrderId());
//	
//	}
//	@Test
//	public void testPostMessage()
//	{
//		//Customer customer =  new Customer(null,17082,"inferno","inf@gmail.com",9777172228L,LocalDate.of(2009, 1, 1),"Door 9","Street 7","Mumbai","Maharashtra","India",769007L,1214);
//		OrderDetail orderDetail1 = new OrderDetail(null,5,22.0,110.0,23);
//		OrderDetail orderDetail2 = new OrderDetail(null,5,22.0,110.0,23);
//		List<OrderDetail>  orderDetailList = Arrays.asList(orderDetail1,orderDetail2);
//		OrderRequest orderRequest = new OrderRequest(null,LocalDate.of(2021, 4, 21),1400.00,180.45,
//													1500.00,"DEBIT","INR",123,3,orderDetailList);
//		
//		ResponseEntity<MessageResponse> result = restTemplate.postForEntity("http://localhost:"+port.toString()+"/rvy/api/oms/v1/orders", orderRequest, MessageResponse.class);
//		//customer.setCustomerId(result.getBody().getCustomerId());
//		
//		assertEquals("Order placed successfully",result.getBody().getMessage());
//		restTemplate.delete("http://localhost:"+port.toString()+"/rvy/api/oms/v1/orders/"+result.getBody().getOrderId());
//	}
//	
//	@Test
//	public void testOrderMasterList()
//	{
//		ResponseEntity<List> orderMasterList =  restTemplate.getForEntity("http://localhost:"+port.toString()+"/rvy/api/oms/v1/orders", List.class);
//		System.out.println(orderMasterList);
//		assertThat(orderMasterList.getStatusCode().equals(HttpStatus.OK));
//	}
//
//}