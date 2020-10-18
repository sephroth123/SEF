package entity;

public class Weight {

	String wId;

	String constraint;

	int weight;

	@Override
	public String toString() {
		return "Weight [wId=" + wId + ", constraint=" + constraint + ", weight=" + weight + "]";
	}

	public String getwId() {
		return wId;
	}

	public void setwId(String wId) {
		this.wId = wId;
	}

	public String getConstraint() {
		return constraint;
	}

	public void setConstraint(String constraint) {
		this.constraint = constraint;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

}
