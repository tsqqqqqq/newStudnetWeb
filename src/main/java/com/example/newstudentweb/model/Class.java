package com.example.newstudentweb.model;

   /**
    * @author uitle 
    * Sat Jan 11 17:42:46 CST 2020
    * <p>class 实体类</P>
    */ 


public class Class{
	private int classId; // 班级 主键Id
	private int majorId;//专业id
	private String classNum;//班级编号


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

