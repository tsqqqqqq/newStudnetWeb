package com.example.newstudentweb.model;

   /**
    * @author uitle 
    * Sat Jan 11 17:42:46 CST 2020
    * <p>admin 实体类</P>
    */ 


public class Admin{
	private int id;//主键Id
	private String adminUsers;//管理员账号
	private String adminPassWord;//管理员密码


public Admin(){
};
	public void setId(int id){
	this.id=id;
	}
	public int getId(){
		return id;
	}
	public void setAdminUsers(String adminUsers){

		this.adminUsers=adminUsers;
	}
	public String getAdminUsers(){

		return adminUsers;
	}
	public void setAdminPassWord(String adminPassWord){
	this.adminPassWord=adminPassWord;
	}
	public String getAdminPassWord(){
		return adminPassWord;
	}
}

