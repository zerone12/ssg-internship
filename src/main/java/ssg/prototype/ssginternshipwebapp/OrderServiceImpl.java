package ssg.prototype.ssginternshipwebapp;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {
	
	@Autowired
	private OrderRepository rep;
	
	@Override
	public List<Order> getAllOrders() {
		return rep.findAll();
	}
	
	@Override
	public Order getOrderById(OrderId id) {
		Optional<Order> orderDb = rep.findById(id);
		
		if (orderDb.isPresent()) {
			return orderDb.get();
		}else {
			return null;
		}
	}

	@Override
	public Order createOrder(Order order) {
		return rep.save(order);
	}

	@Override
	public Order updateOrder(Order order) {
		OrderId id = new OrderId(order.getUserId(), order.getProductId());
		Optional<Order> orderDb = rep.findById(id);
		
		if (orderDb.isPresent()) {
			Order update = orderDb.get();
			
			update.setUserId(order.getUserId());
			update.setProductId(order.getProductId());
			update.setQuantity(order.getQuantity());
			return update;
		} else {
			return null;
		}
	}

	@Override
	public void deleteOrder(OrderId id) {
		Optional<Order> orderDb = rep.findById(id);
		
		if (orderDb.isPresent()) {
			rep.delete(orderDb.get());
		}
	}

	@Override
	public List<Order> getOrderByUserId(long id) {
		List<Order> orderDb = rep.findAll();
		
		if (!orderDb.isEmpty()) {
			Iterator<Order> i = orderDb.iterator();
			
			while (i.hasNext()) {
				Order order = i.next();
				if (order.getUserId() != id)
					i.remove();
			}
			return orderDb;
			
		}else return null;
	}

	@Override
	public List<Order> getOrderByProductId(long id) {
		List<Order> orderDb = rep.findAll();
		
		if (!orderDb.isEmpty()) {
			Iterator<Order> i = orderDb.iterator();
			
			while (i.hasNext()) {
				Order order = i.next();
				if (order.getProductId() != id)
					i.remove();
			}
			return orderDb;
			
		}else return null;
	}
	
}
