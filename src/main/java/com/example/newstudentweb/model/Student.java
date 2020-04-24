package com.example.newstudentweb.model;

   /**
    * @author uitle 
    * Sat Jan 11 17:42:46 CST 2020
    * <p>student 实体类</P>
    */ 


public class Student{
	private int studentId;
	private int dormitoryId;
	private int classId;
	private String studentName;
	private int studentAge;
	private String studentSex;
	private String studentIdNum;
	private int studentType;
	private String studentExamNum;
	private String studentPhone;
	private String studentAddr;
	private String studentEmail;
	private double studentMoney;
	private int studentInFo;
	private String studentActivaTime;
	private int majorId;

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

