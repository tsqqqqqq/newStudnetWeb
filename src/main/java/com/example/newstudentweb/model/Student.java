package com.example.newstudentweb.model;

   /**
    * @author uitle 
    * Sat Jan 11 17:42:46 CST 2020
    * <p>student 实体类</P>
    */ 


public class Student{
	private int studentId;//学生Id
	private int dormitoryId;//宿舍ID
	private int classId;//班级ID
	private String studentName;//学生姓名
	private int studentAge;//学生年龄
	private String studentSex;//学生性别
	private String studentIdNum;//学生学号
	private int studentType;//学生类型
	private String studentExamNum;//学生成绩
	private String studentPhone;//学生联系方式
	private String studentAddr;//学生地址
	private String studentEmail;//学生邮件d
	private double studentMoney;//学生缴费金额
	private int studentInFo;//学生是否激活
	private String studentActivaTime;//激活时间
	private int majorId;//专业I

	   public int getMajorId() {
		   return majorId;
	   }

	   public void setMajorId(int majorId) {
		   this.majorId = majorId;
	   }

	   public Student(){
};
	public void setStudentId(int studentId){
	this.studentId=studentId;
	}
	public int getStudentId(){
		return studentId;
	}
	public void setDormitoryId(int dormitoryId){
	this.dormitoryId=dormitoryId;
	}
	public int getDormitoryId(){
		return dormitoryId;
	}
	public void setClassId(int classId){
	this.classId=classId;
	}
	public int getClassId(){
		return classId;
	}
	public void setStudentName(String studentName){
	this.studentName=studentName;
	}
	public String getStudentName(){
		return studentName;
	}
	public void setStudentAge(int studentAge){
	this.studentAge=studentAge;
	}
	public int getStudentAge(){
		return studentAge;
	}
	public void setStudentSex(String studentSex){
	this.studentSex=studentSex;
	}
	public String getStudentSex(){
		return studentSex;
	}
	public void setStudentIdNum(String studentIdNum){
	this.studentIdNum=studentIdNum;
	}
	public String getStudentIdNum(){
		return studentIdNum;
	}
	public void setStudentType(int studentType){
	this.studentType=studentType;
	}
	public int getStudentType(){
		return studentType;
	}
	public void setStudentExamNum(String studentExamNum){
	this.studentExamNum=studentExamNum;
	}
	public String getStudentExamNum(){
		return studentExamNum;
	}
	public void setStudentPhone(String studentPhone){
	this.studentPhone=studentPhone;
	}
	public String getStudentPhone(){
		return studentPhone;
	}
	public void setStudentAddr(String studentAddr){
	this.studentAddr=studentAddr;
	}
	public String getStudentAddr(){
		return studentAddr;
	}
	public void setStudentEmail(String studentEmail){
	this.studentEmail=studentEmail;
	}
	public String getStudentEmail(){
		return studentEmail;
	}
	public void setStudentMoney(double studentMoney){
	this.studentMoney=studentMoney;
	}
	public double getStudentMoney(){
		return studentMoney;
	}
	public void setStudentInFo(int studentInFo){
	this.studentInFo=studentInFo;
	}
	public int getStudentInFo(){
		return studentInFo;
	}
	public String getStudentActivaTime() { return studentActivaTime; }
	public void setStudentActivaTime(String studentActivaTime) { this.studentActivaTime = studentActivaTime; }

   }

