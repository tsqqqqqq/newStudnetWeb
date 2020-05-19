package com.example.newstudentweb.model;

   /**
    * @author uitle 
    * Sat Jan 11 17:42:46 CST 2020
    * <p>dormitory 实体类</P>
    */ 


public class Dormitory{
	private int dormitoryId;//宿舍主键ID
	private String dormitoryNum;//宿舍编号
	private int Max;//最大容量
	private String dormitoryType;//宿舍类型  男生\女生
	private String  dormitoryAddr;//宿舍地址
	private int classId;//对应的班级


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

