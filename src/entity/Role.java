package entity;

public class Role {

	private String rid;
	private String rName;

	public Role(String rid, String rName) {
		super();
		this.rid = rid;
		this.rName = rName;
	}

	public String getRid() {
		return rid;
	}

	public void setRid(String rid) {
		this.rid = rid;
	}

	public String getrName() {
		return rName;
	}

	public void setrName(String rName) {
		this.rName = rName;
	}

}
