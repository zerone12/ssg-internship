package ssg.prototype.ssginternshipwebapp;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class OrderController {
	
	@Autowired
	private OrderService orderService;
	@Autowired
	private ProductService productService; 
	
	@GetMapping("/orders")
	public String getAllOrders(Model model){
		model.addAttribute("orders", orderService.getAllOrders());
		return "order";
	}
	
	@GetMapping("/orders/{uid}-{pid}")
	public ResponseEntity<Order> getOrderById(@PathVariable long uid, @PathVariable long pid) {
		return ResponseEntity.ok().body(orderService.getOrderById(new OrderId(uid,pid)));
	}
	
	@GetMapping("/orders/byuser/{id}")
	public String getOrderByUserId(Model model, @PathVariable long id) {
		List<Order> orders = orderService.getOrderByUserId(id);
		List<UserOrder> userOrders  = new ArrayList<UserOrder>();
		
		if (orders != null) {
			for (Order o : orders) {
				long pid = o.getProductId();
				Product p = productService.getProductById(pid);
				userOrders.add(new UserOrder(pid, p.getProductName(), o.getQuantity()));
			}
		}
		
		model.addAttribute("user_id", id);
		model.addAttribute("products", userOrders);

		return "order_mod";
	}
	
	@GetMapping("/orders/byproduct/{id}")
	public ResponseEntity<List<Order>> getOrderByProductId(@PathVariable long id) {
		return ResponseEntity.ok().body(orderService.getOrderByProductId(id));
	}
	
	@PostMapping("/orders/new/{id}")
	public String createOrder(Model model, @PathVariable long id, @RequestParam Map<String, String> orders) {
		
		model.addAttribute("task", "order");
		
		//test for orders that go over current stock
		for (Map.Entry<String, String> entry : orders.entrySet()) {
			long pid = Long.parseLong(entry.getKey()); 
			long qty = Long.parseLong(entry.getValue());
			
			if (qty != 0) {
				Product p = productService.getProductById(pid);
				long curStock = p.getStock(); 
				
				if (curStock < qty) {
					return "fail";
				}
			}
		}
		
		List<Order> order = new ArrayList<Order>();
		//since all orders are now valid, make orders
		for (Map.Entry<String, String> entry : orders.entrySet()) {
			long pid = Long.parseLong(entry.getKey()); 
			long qty = Long.parseLong(entry.getValue());
			Product p = productService.getProductById(pid);
			long curStock = p.getStock();
			
			if (qty != 0) {
				Order o = orderService.getOrderById(new OrderId(id,pid));
				
				if (o == null) {
					o = new Order();
					o.setUserId(id);
					o.setProductId(pid);
					o.setQuantity(qty);
				}else {
					qty += o.getQuantity();
				}

				p.setStock(curStock-qty);
				o.setQuantity(qty);
				order.add(orderService.updateOrder(o));
				productService.updateProduct(p);
			}
		}
		
		model.addAttribute("order", order);
		return "success";
	}
	
	@PostMapping("/orders/byuser/{id}")
	public String deleteOrder(Model model, @PathVariable long id, @RequestParam Map<String, String> form) {
		if (form != null) {
			long pid = -1;
			long qty = 0;
			for (Map.Entry<String, String> entry : form.entrySet()) {
				pid = Long.parseLong(entry.getKey());
				qty = Long.parseLong(entry.getValue());
			}
			
			if (pid > 0 && id > 0) {
				Product p = productService.getProductById(pid);
				p.setStock(p.getStock()+qty);
				orderService.deleteOrder(new OrderId(id, pid));
				productService.updateProduct(p);
			}
		}
		
		return "success";
	}
	
	@DeleteMapping("/orders/{uid}-{pid}")
	public HttpStatus updateOrder(@PathVariable long uid, @PathVariable long pid) {
		orderService.deleteOrder(new OrderId(uid,pid));
		return HttpStatus.OK;
	}
}
