package com.cem.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.evalua.entity.support.EntityBase;

@Entity
public class Question extends EntityBase{
	
	public enum Status {
		ACTIVE,DELETED;
	}

	private String question;	
	private User user;
	private List<String> comparators=new ArrayList<String>(0);
	private Integer productFound=0;	
	private Long questionHit=1L;
	private Status status=Status.ACTIVE;
	
	
	public Long getQuestionHit() {
		return questionHit;
	}
	public void setQuestionHit(Long questionHit) {
		this.questionHit = questionHit;
	}
	public Integer getProductFound() {
		return productFound;
	}
	public void setProductFound(Integer productFound) {
		this.productFound = productFound;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	
	@OneToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	@ElementCollection(fetch = FetchType.EAGER)
	@Fetch(FetchMode.SELECT)
	public List<String> getComparators() {
		return comparators;
	}
	public void setComparators(List<String> comparators) {
		this.comparators = comparators;
	}
	
	public void addComparator(String comparator){
		if(!this.comparators.contains(comparator)){
			this.comparators.add(comparator);
		}
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}	
	
}
