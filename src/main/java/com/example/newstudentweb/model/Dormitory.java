package com.example.newstudentweb.model;

   /**
    * @author uitle 
    * Sat Jan 11 17:42:46 CST 2020
    * <p>dormitory 实体类</P>
    */ 


public class Dormitory{
	private int dormitoryId;
	private String dormitoryNum;
	private int Max;
	private String dormitoryType;
	private String  dormitoryAddr;
	private int classId;


public Dormitory(){
};
	public void setDormitoryId(int dormitoryId){
	this.dormitoryId=dormitoryId;
	}
	public int getDormitoryId(){
		return dormitoryId;
	}
	public void setDormitoryNum(String dormitoryNum){
	this.dormitoryNum=dormitoryNum;
	}
	public String getDormitoryNum(){
		return dormitoryNum;
	}

	   public int getMax() {
		   return Max;
	   }

	   public void setMax(int max) {
		   Max = max;
	   }

	   public String getDormitoryType() {
		   return dormitoryType;
	   }

	   public void setDormitoryType(String dormitoryType) {
		   this.dormitoryType = dormitoryType;
	   }

	   public String getDormitoryAddr() {
		   return dormitoryAddr;
	   }

	   public void setDormitoryAddr(String dormitoryAddr) {
		   this.dormitoryAddr = dormitoryAddr;
	   }

	   public int getClassId() {
		   return classId;
	   }

	   public void setClassId(int classId) {
		   this.classId = classId;
	   }
   }

