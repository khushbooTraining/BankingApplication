package com.khushboo.rest.webservices.restful_web_services.jpa;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;


@Entity(name = "User_Detail")
public class UserDetail {
	
	public UserDetail() {
	    // default constructor
	}
	@Id
	@GeneratedValue
	private int id;
	private String name;
	private String address;
	
	@OneToMany(mappedBy="userDetail")
	@JsonIgnore
	private List<Subject> subject;
	
	public UserDetail(int id, String name, String address) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
		return "UserDetail [id=" + id + ", name=" + name + ", address=" + address + "]";
	}
	public List<Subject> getSubject() {
		return subject;
	}
	public void setSubject(List<Subject> subject) {
		this.subject = subject;
	}

}
