package ssg.prototype.ssginternshipwebapp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import ssg.prototype.ssginternshipwebapp.domain.entity.Jumun;
import ssg.prototype.ssginternshipwebapp.domain.entity.Product;
import ssg.prototype.ssginternshipwebapp.domain.repository.OrderRepository;

@Service
public class OrderService {
	private final OrderRepository orderRepository;
	
	public OrderService(OrderRepository orderRepository) {
		this.orderRepository = orderRepository;
	}
	
	public void saveOrder(Long customerId, List<Product> ordered) {
		List<Jumun> orders = new ArrayList<Jumun>();
		for(Product product : ordered) {
			orders.add(new Jumun(customerId, product.getId()));
		}
		orderRepository.saveAll(orders);
	}
}
