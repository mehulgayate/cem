package com.cem.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;

import com.evalua.entity.support.EntityBase;

@Entity
public class Product extends EntityBase{

	private String name;
	private String description;
	private List<Department> departments=new ArrayList<Department>(0);
	private List<Product> comparables=new ArrayList<Product>(0);
	private Long searchCount= 0L;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@ManyToMany(cascade = { CascadeType.ALL}, fetch = FetchType.EAGER)
	public List<Department> getDepartments() {
		return departments;
	}
	public void setDepartments(List<Department> departments) {
		this.departments = departments;
	}
	
	public void addDepartment(Department department){
		for (Department department2 : this.departments) {
			if(department.getName().equals(department2.getName())){
				return;
			}
		}
		this.departments.add(department);
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	@ManyToMany(cascade = { CascadeType.ALL}, fetch = FetchType.LAZY)
	public List<Product> getComparables() {
		return comparables;
	}
	public void setComparables(List<Product> comparables) {
		this.comparables = comparables;
	}	
	
	public void addComparableProduct(Product product){
		for (Product comparable : this.comparables) {
			if(comparable.getId().equals(product.getId())){
				return;
			}
		}
		
		this.comparables.add(product);
	}
	public Long getSearchCount() {
		return searchCount;
	}
	public void setSearchCount(Long searchCount) {
		this.searchCount = searchCount;
	}
}
