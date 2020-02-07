package ssg.prototype.ssginternshipwebapp;

import java.util.List;

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

@Controller
public class ProductController {
	
	@Autowired
	private ProductService productService;

	@GetMapping("/products")
	public String getAllProducts(Model model){
		model.addAttribute("products", productService.getAllProducts());
		return "product";
	}
	
	@GetMapping("/orders/new/{id}")
	public String getAllProductsForOrder(Model model, @PathVariable long id){
		model.addAttribute("products", productService.getAllProducts());
		model.addAttribute("user_id", id);
		return "order_form";
	}
	
	@GetMapping("/products/{id}")
	public ResponseEntity<Product> getProductById(@PathVariable long id) {
		return ResponseEntity.ok().body(productService.getProductById(id));
	}
	
	@PostMapping("/products")
	public ResponseEntity<Product> createProduct(@RequestBody Product product) {
		return ResponseEntity.ok().body(productService.createProduct(product));
	}
	
	@PutMapping("/products/{id}")
	public ResponseEntity<Product> updateProduct(@PathVariable long id, @RequestBody Product product) {
		product.setId(id);
		return ResponseEntity.ok().body(productService.updateProduct(product));
	}
	
	@DeleteMapping("/products/{id}")
	public HttpStatus deleteProduct(@PathVariable long id) {
		productService.deleteProduct(id);
		return HttpStatus.OK;
	}
}
