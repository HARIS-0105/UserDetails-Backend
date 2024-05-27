package com.crud.demo;

import java.sql.Timestamp;
//import lombok.Builder;
//import lombok.*;
import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
//@Builder
@Entity
//@Getter
//@Setter
public class Users {
	@Id
	private String email;
	
//	String fname,lname,mob_no,dob,address;
	
	private String fname;
	
	private String lname;
	
	private String mobNo;
	
	private Date dob;
	
	private String address;
	
	private Timestamp createDate;
	
	private java.sql.Timestamp modifyDate;

	public Users(String email, String fname, String lname, String mobNo, Date dob, String address, Timestamp createDate,
			Timestamp modifyDate) {
		super();
		this.email = email;
		this.fname = fname;
		this.lname = lname;
		this.mobNo = mobNo;
		this.dob = dob;
		this.address = address;
		this.createDate = createDate;
		this.modifyDate = modifyDate;
	}

	public Users() {
		// TODO Auto-generated constructor stub
	}

	public Timestamp getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Timestamp createdOn) {
		this.createDate = createdOn;
	}

	public Timestamp getModifyDate() {
		return modifyDate;
	}

	public void setModifyDate(Timestamp createdOn) {
		this.modifyDate = createdOn;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getmobNo() {
		return mobNo;
	}

	public void setmobNo(String mobNo) {
		this.mobNo = mobNo;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Users [email=" + email + ", fname=" + fname + ", lname=" + lname + ", mobNo=" + mobNo + ", dob=" + dob
				+ ", address=" + address + ", createDate=" + createDate + ", modifyDate=" + modifyDate + "]";
	}

}
