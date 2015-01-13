package com.cem.entity;

import javax.persistence.Entity;

import com.evalua.entity.support.EntityBase;

@Entity
public class Department extends EntityBase{

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	
	
}
