package ssg.prototype.ssginternshipwebapp;

import java.io.Serializable;
import java.util.Objects;

public class OrderId implements Serializable {
	
	private long userId, productId;
	
	public OrderId() {
	}
	
	public OrderId(long userId, long productId) {
		this.productId = productId;
		this.userId = userId;
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		
		OrderId that = (OrderId) o;
		return productId == that.productId && userId == that.userId;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(userId, productId);
	}
}
