package com.example.demo.model;

import java.util.Objects;

public class UserRegistrationModel {
	
	private String id;
	private String name;
	private String role;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	@Override
	public String toString() {
		return "UserRegistrationModel [id=" + id + ", name=" + name + ", role=" + role + "]";
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(id, name, role);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserRegistrationModel other = (UserRegistrationModel) obj;
		return Objects.equals(id, other.id) && Objects.equals(name, other.name) && Objects.equals(role, other.role);
	}

}
