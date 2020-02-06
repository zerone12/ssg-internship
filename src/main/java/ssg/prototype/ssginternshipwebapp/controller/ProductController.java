package ssg.prototype.ssginternshipwebapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ssg.prototype.ssginternshipwebapp.domain.entity.Product;
import ssg.prototype.ssginternshipwebapp.domain.repository.ProductRepository;
import ssg.prototype.ssginternshipwebapp.service.OrderService;
import ssg.prototype.ssginternshipwebapp.service.ProductService;

@Controller
@EnableAutoConfiguration
@RequestMapping(value = "/product")
public class ProductController {

	@Autowired
	ProductRepository productRepository;
	
	@Autowired
	ProductService productService;
	
	@Autowired
	OrderService orderService;

	@GetMapping({"","/"})
	public String showProducts(Model model) {
		
		List<Product> lp = productRepository.findAll();
//		return lp.toString();
//		return lp.get(0).getName();
		model.addAttribute("productList", lp);
		return "/product/list";
	}
	
	@PostMapping("/order")
	public String orderProducts(@RequestParam String[] checked,Model model) {
		List<Product> ordered = productService.findProductsById(checked);
		// orderService를 만들어야 함!! // ordered에 넣어줘야 한다!!
		orderService.saveOrder(1l, ordered);
		model.addAttribute("ordered", ordered);
		return "/product/order";
	}
}
