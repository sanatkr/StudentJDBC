package com.student.entity;

public class StudentEntity {
	
	int rollNo;
	String name;
	String address;
	public int getRollNo() {
		return rollNo;
	}
	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "StudentEntity [rollNo=" + rollNo + ", name=" + name + ", address=" + address + "]";
	}
	
	

}
