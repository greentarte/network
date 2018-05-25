package com.hw.vo;


public class Member {
	String email;
	String pwd;
	String name;
	String publicDistance;
	String personalMileage;

	public Member() {
	}

	public Member(String email, String pwd, String name, String publicDistance, String personalMileage) {
		this.email = email;
		this.pwd = pwd;
		this.name = name;
		this.publicDistance = publicDistance;
		this.personalMileage = personalMileage;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPublicDistance() {
		return publicDistance;
	}

	public void setPublicDistance(String publicDistance) {
		this.publicDistance = publicDistance;
	}

	public String getPersonalMileage() {
		return personalMileage;
	}

	public void setPersonalMileage(String personalMileage) {
		this.personalMileage = personalMileage;
	}

	@Override
	public String toString() {
		return "Member [email=" + email + ", pwd=" + pwd + ", name=" + name + ", publicDistance=" + publicDistance
				+ ", personalMileage=" + personalMileage + "]";
	}

}
