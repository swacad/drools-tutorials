package course;

import java.util.ArrayList;
import java.util.List;

public class Order {
	private List<OrderLine> orderLines = new ArrayList<OrderLine>();

	public List<OrderLine> getOrderLines() {
		return orderLines;
	}

	public void setOrderLines(List<OrderLine> orderLines) {
		this.orderLines = orderLines;
	}
	
}
