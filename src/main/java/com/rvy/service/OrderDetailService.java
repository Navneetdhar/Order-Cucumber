package com.rvy.service;

import java.util.List;

import com.rvy.entity.OrderDetail;
import com.rvy.exception.OrderException;

public interface OrderDetailService {
	public abstract List<OrderDetail> getAllOrders() throws OrderException;
	OrderDetail getOrderDetailsById(Integer id) throws OrderException;
	OrderDetail addOrderDetail(OrderDetail order) throws OrderException;
	OrderDetail updateOrderDetail(OrderDetail order) throws OrderException;
	public abstract Integer deleteOrder(Integer orderDetailId) throws OrderException; 

}
