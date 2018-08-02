package course;

public class Product {
	private String name;
	private String transportType;
	private double height;
	private double width;
	private double depth;
	private double weight;
	
	
	
	/**
	 * @param name
	 * @param transportType
	 * @param height
	 * @param width
	 * @param depth
	 * @param weight
	 */
	public Product(String name, String transportType, double height, double width, double depth, double weight) {
		super();
		this.name = name;
		this.transportType = transportType;
		this.height = height;
		this.width = width;
		this.depth = depth;
		this.weight = weight;
	}
	
	
	
	/**
	 * @param name
	 * @param transportType
	 */
	public Product(String name, String transportType) {
		super();
		this.name = name;
		this.transportType = transportType;
	}

	
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}



	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getHeight() {
		return height;
	}
	public void setHeight(double height) {
		this.height = height;
	}
	public double getWidth() {
		return width;
	}
	public void setWidth(double width) {
		this.width = width;
	}
	public double getDepth() {
		return depth;
	}
	public void setDepth(double depth) {
		this.depth = depth;
	}
	public String getTransportType() {
		return transportType;
	}
	public void setTransportType(String transportType) {
		this.transportType = transportType;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	

}
