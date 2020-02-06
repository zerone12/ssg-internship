package ssg.prototype.ssginternshipwebapp.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import ssg.prototype.ssginternshipwebapp.domain.entity.Product;
import ssg.prototype.ssginternshipwebapp.domain.repository.ProductRepository;

@Controller
@EnableAutoConfiguration
@RequestMapping(value = "/product")
public class ProductController {

	@Autowired
	ProductRepository productRepository;

	@GetMapping({"","/"})
	public String showProducts(Model model) {
		
		List<Product> lp = productRepository.findAll();
//		return lp.toString();
//		return lp.get(0).getName();
		model.addAttribute("productList", lp);
		return "/product/list";
	}
	
	@PostMapping("/order")
	public String orderProducts(@RequestBody Map<String, String[]> param,Model model) {
		String[] checked = param.get("checked");
		System.out.println("checked: "+checked[0]);
		return "/product/order";
	}
}
