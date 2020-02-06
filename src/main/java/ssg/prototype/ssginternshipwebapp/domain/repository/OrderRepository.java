package ssg.prototype.ssginternshipwebapp.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ssg.prototype.ssginternshipwebapp.domain.entity.Jumun;

@Repository
public interface OrderRepository extends JpaRepository<Jumun, Long>{
	public List<Jumun> findByCustomerId(Long customerId);
	public List<Jumun> findByProductId(Long productId);
}
