package ssg.prototype.ssginternshipwebapp;

public class UserOrder {
	private long productId;
	private String productName;
	private long quantity;
	
	
	public UserOrder(long productId, String productName, long quantity) {
		this.productId = productId;
		this.productName = productName;
		this.quantity = quantity;
	}
	
	public long getProductId() {
		return productId;
	}
	public void setProductId(long productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public long getQuantity() {
		return quantity;
	}
	public void setQuantity(long quantity) {
		this.quantity = quantity;
	}
	
}
