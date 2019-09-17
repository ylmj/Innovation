package com.basic.model;


//平台院长
public class Dean {
	private int id;
	private String name;
	private String sex;
	private String date;//出生年月
	private String jobTitle;//职称
	private String major;//所学专业
	private String education;//学历
	private String degree;//学位
	private String telephone;//电话
	private String mobilephone;//手机号码
	private String email;//电子邮箱
	public Dean() {}
	public Dean(String name,String sex,String date,String jobTitle,String major,String education,String degree,String telephone,String mobilephone,String email)
	{
		this.name=name;
		this.sex=sex;
		this.date=date;
		this.jobTitle=jobTitle;
		this.major=major;
		this.education=education;
		this.degree=degree;
		this.telephone=telephone;
		this.mobilephone=mobilephone;
		this.email=email;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getJobTitle() {
		return jobTitle;
	}
	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public String getEducation() {
		return education;
	}
	public void setEducation(String education) {
		this.education = education;
	}
	public String getDegree() {
		return degree;
	}
	public void setDegree(String degree) {
		this.degree = degree;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getMobilephone() {
		return mobilephone;
	}
	public void setMobilephone(String mobilephone) {
		this.mobilephone = mobilephone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	

}
