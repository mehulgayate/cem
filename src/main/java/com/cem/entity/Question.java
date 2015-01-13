package com.cem.entity;

import java.util.List;

import javax.persistence.Entity;

import com.evalua.entity.support.EntityBase;

@Entity
public class Question extends EntityBase{

	private String question;	
	private List<String> comparator;
	
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public List<String> getComparator() {
		return comparator;
	}
	public void setComparator(List<String> comparator) {
		this.comparator = comparator;
	}
	
}
