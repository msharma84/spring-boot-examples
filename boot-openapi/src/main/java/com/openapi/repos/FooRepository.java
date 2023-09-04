package com.openapi.repos;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.openapi.entity.Foo;


@Component
public class FooRepository {
	
	private List<Foo> fooList = new ArrayList<>();
	
	public List<Foo> get(){
		return fooList;
	}
	
	public void add(Foo foo) {
		fooList.add(foo);
	}
	
	public void delete(Integer id) {
		
	}

	public List<Foo> getFooList() {
		return fooList;
	}

	public void setFooList(List<Foo> fooList) {
		this.fooList = fooList;
	}
}
