package com.openapi.entity;

import java.util.Objects;

import org.springframework.stereotype.Component;

@Component
public class Foo {

	
	public Foo() {}
	
	public Foo(Integer id, String name) {
		this.id = id;
		this.name = name;
	}

	private Integer id;
	private String name;
	
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
	
	@Override
	public String toString() {
		return "Foo [id=" + id + ", name=" + name + "]";
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(id, name);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Foo other = (Foo) obj;
		return Objects.equals(id, other.id) && Objects.equals(name, other.name);
	}
}
