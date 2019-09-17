package com.basic.model;


public class User {
	private int id;//id
	private String username;
	private String password;
	private String platformName;//平台名称
	private String platformNo;//平台编号
	private String approvalDate;//批准年号
	private String approvalNum;//批准文号
	private String field;//技术领域
	public User() {}
	public User(String username,String password,String platformName,String platformNo,String approvalDate,String approvalNum,String field)
	{
		this.username=username;
		this.password=password;
		this.platformName=platformName;
		this.platformNo=platformNo;
		this.approvalDate=approvalDate;
		this.approvalNum=approvalNum;
		this.field=field;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPlatformName() {
		return platformName;
	}
	public void setPlatformName(String platformName) {
		this.platformName = platformName;
	}
	public String getPlatformNo() {
		return platformNo;
	}
	public void setPlatformNo(String platformNo) {
		this.platformNo = platformNo;
	}
	public String getApprovalDate() {
		return approvalDate;
	}
	public void setApprovalDate(String approvalDate) {
		this.approvalDate = approvalDate;
	}
	public String getApprovalNum() {
		return approvalNum;
	}
	public void setApprovalNum(String approvalNum) {
		this.approvalNum = approvalNum;
	}
	public String getField() {
		return field;
	}
	public void setField(String field) {
		this.field = field;
	}
	

}
