package com.khushboo.rest.webservices.restful_web_services.jpa;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity(name="Subject_list")
public class Subject {
	
	@Id
	@GeneratedValue
	private int id;
	private String subjectlist;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JsonIgnore
	private UserDetail userDetail;
	
	public Subject() {
		
	}
	
	/*public Subject(int id, String subject, UserDetail userDetail) {
		super();
		this.id = id;
		this.subject = subject;
		this.userDetail = userDetail;
	}*/

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	
	public String getSubjectlist() {
		return subjectlist;
	}

	public void setSubjectlist(String subjectlist) {
		this.subjectlist = subjectlist;
	}

	public UserDetail getUserDetail() {
		return userDetail;
	}

	public void setUserDetail(UserDetail userDetail) {
		this.userDetail = userDetail;
	}

}