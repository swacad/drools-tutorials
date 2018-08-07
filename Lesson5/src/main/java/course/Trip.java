package course;

import java.util.ArrayList;
import java.util.List;

public class Trip {
	private List<Step> steps = new ArrayList<Step>();
	
	

	/**
	 * 
	 */
	public Trip() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param steps
	 */
	public Trip(List<Step> steps) {
		super();
		this.steps = steps;
	}

	public List<Step> getSteps() {
		return steps;
	}

	public void setSteps(List<Step> steps) {
		this.steps = steps;
	}

}
