package ssg.prototype.ssginternshipwebapp;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductRepository rep;
	
	@Override
	public List<Product> getAllProducts() {
		return rep.findAll();
	}
	
	@Override
	public Product getProductById(long id) {
		Optional<Product> productDb = rep.findById(id);
		
		if (productDb.isPresent()) {
			return productDb.get();
		}else {
			return null;
		}
	}

	@Override
	public Product createProduct(Product product) {
		return rep.save(product);
	}

	@Override
	public Product updateProduct(Product product) {
		Optional<Product> productDb = rep.findById(product.getId());
		
		if (productDb.isPresent()) {
			Product update = productDb.get();
			
			update.setId(product.getId());
			update.setProductName(product.getProductName());
			update.setPrice(product.getPrice());
			update.setStock(product.getStock());
			return update;
		} else {
			return null;
		}
	}

	@Override
	public void deleteProduct(long id) {
		Optional<Product> productDb = rep.findById(id);
		
		if (productDb.isPresent()) {
			rep.delete(productDb.get());
		}
	}
	
}
