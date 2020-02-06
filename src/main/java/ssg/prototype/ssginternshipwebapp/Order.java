package ssg.prototype.ssginternshipwebapp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name="ORDERS")
@IdClass(OrderId.class)
public class Order {

	@Id
	@Column(name="user_id")
	private long userId;
	
	@Id
	@Column(name="product_id")
	private long productId;
	
	@Column(name="quantity")
	private long quantity;

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}
	
	public long getProductId() {
		return productId;
	}

	public void setProductId(long productId) {
		this.productId = productId;
	}

	public long getQuantity() {
		return quantity;
	}

	public void setQuantity(long quantity) {
		this.quantity = quantity;
	}
	
	@Override
	public String toString() {
		String pk = String.format("(u%1$d|p%2$d)", userId, productId);
		return "OrderEntity ["
				+ pk + ", " + productId + ", " + quantity + "]";
	}
}
