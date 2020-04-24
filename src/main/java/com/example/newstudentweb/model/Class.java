package com.example.newstudentweb.model;

   /**
    * @author uitle 
    * Sat Jan 11 17:42:46 CST 2020
    * <p>class 实体类</P>
    */ 


public class Class{
	private int classId;
	private int majorId;
	private String classNum;


public Class(){
};
	public void setClassId(int classId){
	this.classId=classId;
	}
	public int getClassId(){
		return classId;
	}
	public void setClassNum(String classNum){
	this.classNum=classNum;
	}
	public String getClassNum(){
		return classNum;
	}
	public int getMajorId() { return majorId; }
	public void setMajorId(int majorId) { this.majorId = majorId; }

   }

