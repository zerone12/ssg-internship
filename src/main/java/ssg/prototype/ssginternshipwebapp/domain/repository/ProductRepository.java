package ssg.prototype.ssginternshipwebapp.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ssg.prototype.ssginternshipwebapp.domain.entity.Customer;
import ssg.prototype.ssginternshipwebapp.domain.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
	public List<Customer> findByName(String name);
	//like검색도 가능
	public List<Customer> findByNameLike(String keyword);

}
