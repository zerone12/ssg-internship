package ssg.prototype.ssginternshipwebapp;

import java.util.List;

public interface ProductService {
	Product createProduct(Product product);
	
	Product updateProduct(Product product);
	
	List<Product> getAllProducts();
	
	Product getProductById(long id);
	
	void deleteProduct(long id);
}
