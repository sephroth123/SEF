package entity;

public class Team {

	private String tid;
	private String p_id;
	private String s_id1;
	private String s_id2;
	private String s_id3;
	private String s_id4;
	private int satisfaction;

	public int getSatisfaction() {
		return satisfaction;
	}

	public void setSatisfaction(int satisfaction) {
		this.satisfaction = satisfaction;
	}

	public String getTid() {
		return tid;
	}

	public void setTid(String tid) {
		this.tid = tid;
	}

	public String getS_id1() {
		return s_id1;
	}

	public void setS_id1(String s_id1) {
		this.s_id1 = s_id1;
	}

	public String getS_id2() {
		return s_id2;
	}

	public void setS_id2(String s_id2) {
		this.s_id2 = s_id2;
	}

	public String getS_id3() {
		return s_id3;
	}

	public void setS_id3(String s_id3) {
		this.s_id3 = s_id3;
	}

	public String getS_id4() {
		return s_id4;
	}

	public void setS_id4(String s_id4) {
		this.s_id4 = s_id4;
	}

	public String getP_id() {
		return p_id;
	}

	public void setP_id(String p_id) {
		this.p_id = p_id;
	}

}