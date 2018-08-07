package course;

public class Step {
	private int stepNum;
	private String startCity;
	private String arrivalCity;
	private double distance;
	private String travelMode;
	

	/**
	 * @param stepNum
	 * @param startCity
	 * @param arrivalCity
	 * @param distance
	 * @param travelMode
	 */
	public Step(int stepNum, String startCity, String arrivalCity, double distance, String travelMode) {
		super();
		this.stepNum = stepNum;
		this.startCity = startCity;
		this.arrivalCity = arrivalCity;
		this.distance = distance;
		this.travelMode = travelMode;
	}
	public int getStepNum() {
		return stepNum;
	}
	public void setStepNum(int stepNum) {
		this.stepNum = stepNum;
	}
	public String getStartCity() {
		return startCity;
	}
	public void setStartCity(String startCity) {
		this.startCity = startCity;
	}
	public String getArrivalCity() {
		return arrivalCity;
	}
	public void setArrivalCity(String arrivalCity) {
		this.arrivalCity = arrivalCity;
	}
	public double getDistance() {
		return distance;
	}
	public void setDistance(double distance) {
		this.distance = distance;
	}
	public String getTravelMode() {
		return travelMode;
	}
	public void setTravelMode(String travelMode) {
		this.travelMode = travelMode;
	}
}
