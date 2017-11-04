package org.arc.entity;
/**
 * @author Mrruan  E-mail:qkmc@outlook.com
 * @version 创建时间：2017年10月28日 下午4:55:57
 */
public class User {
	private int uId;
	private String uNeckName;
	private String uAccount;
	private String uPassword;
	private String uOldPwd;
	private int uPhone;
	private String uMail;
	
	public User() {
		super();
	}
	
	public User(int uId, String uNeckName, String uAccount, String uPassword,
			String uOldPwd, int uPhone, String uMail) {
		super();
		this.uId = uId;
		this.uNeckName = uNeckName;
		this.uAccount = uAccount;
		this.uPassword = uPassword;
		this.uOldPwd = uOldPwd;
		this.uPhone = uPhone;
		this.uMail = uMail;
	}
	
	//getters and setters
	public int getuId() {
		return uId;
	}
	public void setuId(int uId) {
		this.uId = uId;
	}
	public String getuNeckName() {
		return uNeckName;
	}
	public void setuNeckName(String uNeckName) {
		this.uNeckName = uNeckName;
	}
	public String getuAccount() {
		return uAccount;
	}
	public void setuAccount(String uAccount) {
		this.uAccount = uAccount;
	}
	public String getuPassword() {
		return uPassword;
	}
	public void setuPassword(String uPassword) {
		this.uPassword = uPassword;
	}
	public String getuOldPwd() {
		return uOldPwd;
	}
	public void setuOldPwd(String uOldPwd) {
		this.uOldPwd = uOldPwd;
	}
	public int getuPhone() {
		return uPhone;
	}
	public void setuPhone(int uPhone) {
		this.uPhone = uPhone;
	}
	public String getuMail() {
		return uMail;
	}
	public void setuMail(String uMail) {
		this.uMail = uMail;
	}
	
	
}
