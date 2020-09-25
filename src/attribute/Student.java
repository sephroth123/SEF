package entity;

import java.util.*;
import java.util.stream.Stream;

import Student.service.InputDuplicatedExcepiton;
import Student.service.InputNumberMixmatchException;

public class Student {

	private String sid;
	private String userName;
	private String password;
	private String gender;
	private String personalityType;
	private int experience;
	private double gpa;
    

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

	public Integer getExperience() {
		return experience;
	}

	public void setExperience(Integer experience) {
		this.experience = experience;
	}

	public double getGpa() {
		return gpa;
	}

	public void setGpa(double gpa) {
		this.gpa = gpa;
	}
}
