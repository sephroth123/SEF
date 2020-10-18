package entity;

public class ProjectRole {

	private String id;
	private String p_id;
	private String rf_id;

	public ProjectRole() {
		super();
	}

	public ProjectRole(String id, String p_id, String rf_id) {
		super();
		this.id = id;
		this.p_id = p_id;
		this.rf_id = rf_id;
	}

	@Override
	public String toString() {
		return "ProjectRole [id=" + id + ", p_id=" + p_id + ", rf_id=" + rf_id + "]";
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getP_id() {
		return p_id;
	}

	public void setP_id(String p_id) {
		this.p_id = p_id;
	}

	public String getRf_id() {
		return rf_id;
	}

	public void setRf_id(String rf_id) {
		this.rf_id = rf_id;
	}

}
