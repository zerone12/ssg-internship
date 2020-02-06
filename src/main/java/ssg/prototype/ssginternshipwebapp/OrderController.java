package ssg.prototype.ssginternshipwebapp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {
	
	@Autowired
	private OrderService orderService;
	
	@GetMapping("/orders")
	public ResponseEntity<List<Order>> getAllOrders(){
		return ResponseEntity.ok().body(orderService.getAllOrders());
	}
	
	@GetMapping("/orders/{uid}-{pid}")
	public ResponseEntity<Order> getOrderById(@PathVariable long uid, @PathVariable long pid) {
		return ResponseEntity.ok().body(orderService.getOrderById(new OrderId(uid,pid)));
	}
	
	@GetMapping("/orders/byuser/{id}")
	public ResponseEntity<List<Order>> getOrderByUserId(@PathVariable long id) {
		return ResponseEntity.ok().body(orderService.getOrderByUserId(id));
	}
	@GetMapping("/orders/byproduct/{id}")
	public ResponseEntity<List<Order>> getOrderByProductId(@PathVariable long id) {
		return ResponseEntity.ok().body(orderService.getOrderByProductId(id));
	}
	
	@PostMapping("/orders")
	public ResponseEntity<Order> createOrder(@RequestBody Order order) {
		return ResponseEntity.ok().body(orderService.createOrder(order));
	}
	
	@PutMapping("/orders/{uid}-{pid}")
	public ResponseEntity<Order> updateOrder(@PathVariable long uid, @PathVariable long pid, @RequestBody Order order) {
		order.setUserId(uid);
		order.setProductId(pid);
		return ResponseEntity.ok().body(orderService.updateOrder(order));
	}
	
	@DeleteMapping("/orders/{uid}-{pid}")
	public HttpStatus deleteOrder(@PathVariable long uid, @PathVariable long pid) {
		orderService.deleteOrder(new OrderId(uid,pid));
		return HttpStatus.OK;
	}
}
