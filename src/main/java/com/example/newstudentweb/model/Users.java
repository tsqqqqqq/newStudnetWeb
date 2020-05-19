package com.example.newstudentweb.model;

   /**
    * @author uitle 
    * Sat Jan 11 17:42:46 CST 2020
    * <p>users 实体类</P>
    */ 


public class Users{
	private int userId;//用户ID 主键 其实就是学生登陆的信息主键
	private String studentIdNum;//学生账号
	private String studentPassWord;//学生的密码
	private String createDate;//创建的时间




	   public Users(){
};
	public void setUserId(int userId){
	this.userId=userId;
	}
	public int getUserId(){
		return userId;
	}
	public void setStudentIdNum(String studentIdNum){
	this.studentIdNum=studentIdNum;
	}
	public String getStudentIdNum(){
		return studentIdNum;
	}
	public void setStudentPassWord(String studentPassWord){
	this.studentPassWord=studentPassWord;
	}
	public String getStudentPassWord(){
		return studentPassWord;
	}
	public String getCreateDate() { return createDate;}
	public void setCreateDate(String createDate) { this.createDate = createDate; }
}

