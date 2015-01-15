package com.cem.entity.support;

import org.springframework.web.multipart.MultipartFile;

public class FileUploadForm {

	public static final String key="fileUploadForm";
	
	public enum Type{
		PRODUCT,DEPARTMENT;
	}
	
	private MultipartFile csvFile;
	private Type type;

	public MultipartFile getCsvFile() {
		return csvFile;
	}

	public void setCsvFile(MultipartFile csvFile) {
		this.csvFile = csvFile;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	
	
}
