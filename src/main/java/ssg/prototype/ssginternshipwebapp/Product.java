package ssg.prototype.ssginternshipwebapp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="PRODUCTS")
public class Product {

	@Id
	@GeneratedValue
	@Column(name="product_id")
	private long id;
	
	@Column(name="product_name")
	private String productName;
	
	@Column(name="price")
	private String price;
	
	@Column(name="stock")
	private long stock;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public long getStock() {
		return stock;
	}

	public void setStock(long stock) {
		this.stock = stock;
	}
	
	@Override
	public String toString() {
		return "ProductEntity ["
				+ id + ", " + productName + ", " + price + ", " + stock + "]";
	}
	
}
