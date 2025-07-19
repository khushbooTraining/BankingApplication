package com.khushboo.rest.webservices.restful_web_services.user;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

public class User {
	

	private Integer id;
	@Size(min=2, message="atleat two character should be enter")
	@NotEmpty(message="name should not be empty")
	@JsonProperty("user_name")
	private String name;
	@NotNull(message="birthDate should not be null")
	@Past(message="birthDate should be past")
	@JsonProperty("birth-date")
	private LocalDate birthDate;

	
	public User(int i, String string, LocalDate minusYears) {
		super();
		this.id=i;
		this.name=string;
		this.birthDate=minusYears;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public LocalDate getBirthdate() {
		return birthDate;
	}
	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", birthDate=" + birthDate + "]";
	}
	
}
