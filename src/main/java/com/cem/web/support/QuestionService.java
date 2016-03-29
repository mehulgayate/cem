package com.cem.web.support;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.cem.entity.Department;
import com.cem.entity.Product;
import com.cem.entity.Question;
import com.cem.entity.Question.Status;
import com.cem.entity.support.Repository;
import com.evalua.entity.support.DataStoreManager;


public class QuestionService {

	private Repository repository;
	private DataStoreManager dataStoreManager;


	public void setRepository(Repository repository) {
		this.repository = repository;
	}
	public void setDataStoreManager(DataStoreManager dataStoreManager) {
		this.dataStoreManager = dataStoreManager;
	}	

	public void processQuestion(Question question){

		Matcher matcher = Pattern.compile("#\\s*(\\w+)").matcher(question.getQuestion());
		while (matcher.find()) {
			question.addComparator(matcher.group(1));
		}
		int productFound=0;

		List<Product> comparableProducts = question.getComparableProducts();
		if(question.getComparators().size()>1){
			for (String comparatorString : question.getComparators()) {
					Product product=repository.findProductByName(comparatorString);					
					if(product!=null){
						System.out.println("**** Found Product "+product.getName());
						for (String comparatorStringInner : question.getComparators()) {							
							if(!comparatorString.equals(comparatorStringInner)){								
								Product comparableProduct=repository.findProductByName(comparatorStringInner);
							
								if(comparableProduct!=null){
									productFound++;
									System.out.println("**** Found Comparable  "+comparableProduct.getName());
									
									List<String> depStrings=new ArrayList<String>();
									for (Department dept : product.getDepartments()) {
										depStrings.add(dept.getName());
									}
									
									boolean foundDept =false;
									for (Department department : comparableProduct.getDepartments()) {
										System.out.println(depStrings+"   *** "+department.getName());
										if(depStrings.contains(department.getName())){
											product.addComparableProduct(comparableProduct);											
											foundDept=true;
											System.out.println("**** "+foundDept);
											
											boolean proExists = false;
											for (Product cProduct : comparableProducts) {
												if(cProduct.getId().equals(product)){
													proExists = true;
													break;
												}
											}
											
											if(!proExists){
												comparableProducts.add(product);
											}
											
											break;
										}
									}
									
									if(!foundDept){
										question.setStatus(Status.DELETED);
									}
									
								}
							}
						}										
						dataStoreManager.save(product);
					}
			}
		}
		question.setProductFound(productFound);		
	}

}
