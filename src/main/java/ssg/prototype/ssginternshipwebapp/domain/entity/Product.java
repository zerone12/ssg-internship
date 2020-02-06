package ssg.prototype.ssginternshipwebapp.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
@Getter
@Entity
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(length = 20, nullable = false)
	private String name;
	
	@Column(nullable = false)
	private int price;
	
	@Column(nullable = false)
	private int stock;

	@Builder
	public Product(String name, int price, int stock) {
		this.name = name;
		this.price = price;
		this.stock = stock;
	}
}
