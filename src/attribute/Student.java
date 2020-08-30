package attribute;

public class Student {

	private String sid;
	private String userName;
	private String password;
	private String gender;
	private String personalityType;
	private String experience;
	private String disSid1;
	private String disSid2;
	private String disSid3;
	private double gpa;

	public String getDisSid1() {
		return disSid1;
	}

	public void setDisSid1(String disSid1) {
		this.disSid1 = disSid1;
	}

	public String getDisSid2() {
		return disSid2;
	}

	public void setDisSid2(String disSid2) {
		this.disSid2 = disSid2;
	}

	public String getDisSid3() {
		return disSid3;
	}

	public void setDisSid3(String disSid3) {
		this.disSid3 = disSid3;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSid() {
		return sid;
	}

	public void setSid(String sid) {
		this.sid = sid;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPersonalityType() {
		return personalityType;
	}

	public void setPersonalityType(String personalityType) {
		this.personalityType = personalityType;
	}

	public String getExperience() {
		return experience;
	}

	public void setExperience(String experience) {
		this.experience = experience;
	}

	public double getGpa() {
		return gpa;
	}

	public void setGpa(double gpa) {
		this.gpa = gpa;
	}

}
