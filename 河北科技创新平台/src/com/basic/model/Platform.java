package com.basic.model;
//ƽ̨���Ϣ
public class Platform {
	public static int NATIONAL=1;//���Ҽ�
	public static int PROVINCIAL=2;//ʡ��
	public static int RELATIVE_INDEPENDENT=1;//���������Զ���
	public static int ENTERPRISE=2;//������ҵ����
	public static int COUSE=3;//������ҵ����
	public static int ASSOCIATION=4;//�������ŷ���
	public static int SAVED=1;//�ѱ���
	public static int SUBMITTED=2;//���ύ
	private int id;
	private User user;//�û�
	private Dean dean;//ƽ̨����
	private Organization organization;//���е�λ
	private int grade;//ƽ̨����
	private String district;//��������
	
	private int form;//ƽ̨��֯��̬
	
	private boolean unite;//����or����
	
	private boolean jjjgj;//�Ƿ񾩽򼽹���
	
    private String industry;//��Ҫ���񾭼���ҵ
    private String subject;//��Ҫѧ��
    private String []gjdw;//������λ
    private String sitename;//ƽ̨��վ������
    private String website;//ƽ̨��վ��ַ
    private String addr;//ƽ̨ͨѶ��ַ
    private String postcode;//�ʱ�
    private int status;//״̬
    public Platform() {}
    public Platform(User user,Organization organization,Dean dean,int grade,
    		String district,int form,boolean unite,boolean jjjgj,String industry,
    		String subject,String []gidw,String sitename,String website,String addr,String postcode,int status)
    {
    	this.user=user;
    	this.organization=organization;
    	this.dean=dean;
    	this.grade=grade;
    	this.district=district;
    	this.form=form;
    	this.unite=unite;
    	this.jjjgj=jjjgj;
    	this.industry=industry;
    	this.subject=subject;
    	this.gjdw=gidw;
    	this.sitename=sitename;
    	this.website=website;
    	this.addr=addr;
    	this.postcode=postcode;
    	this.status=status;
    }
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Dean getDean() {
		return dean;
	}
	public void setDean(Dean dean) {
		this.dean = dean;
	}
	public Organization getOrganization() {
		return organization;
	}
	public void setOrganization(Organization organization) {
		this.organization = organization;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public int getForm() {
		return form;
	}
	public void setForm(int form) {
		this.form = form;
	}
	public boolean isUnite() {
		return unite;
	}
	public void setUnite(boolean unite) {
		this.unite = unite;
	}
	public boolean isJjjgj() {
		return jjjgj;
	}
	public void setJjjgj(boolean jjjgj) {
		this.jjjgj = jjjgj;
	}
	public String getIndustry() {
		return industry;
	}
	public void setIndustry(String industry) {
		this.industry = industry;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String[] getGjdw() {
		return gjdw;
	}
	public void setGjdw(String[] gjdw) {
		this.gjdw = gjdw;
	}
	public String getSitename() {
		return sitename;
	}
	public void setSitename(String sitename) {
		this.sitename = sitename;
	}
	public String getWebsite() {
		return website;
	}
	public void setWebsite(String website) {
		this.website = website;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getPostcode() {
		return postcode;
	}
	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
}
