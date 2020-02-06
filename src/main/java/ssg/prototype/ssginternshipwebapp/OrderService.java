package ssg.prototype.ssginternshipwebapp;

import java.util.List;

public interface OrderService {
	Order createOrder(Order order);
	
	Order updateOrder(Order order);
	
	List<Order> getAllOrders();
	
	Order getOrderById(OrderId id);
	
	List<Order> getOrderByUserId(long id);
	
	List<Order> getOrderByProductId(long id);
	
	void deleteOrder(OrderId id);
}
