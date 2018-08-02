package course;

import java.util.List;

public class Order {
	private List<Product> products;
	private int quantity;
	
	
	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public List<Product> getProducts() {
		return products;
	}
	public void setProducts(List<Product> products) {
		this.products = products;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
}
