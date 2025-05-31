package com.krishana.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data

@NoArgsConstructor
public class ResourceNotFoundException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String userFiled;
	private String filed;
	private Integer value;
	
	public ResourceNotFoundException(String userFiled, String filed, Integer value) {
		super(String.format(" %s  not Found With %s : %s "  ,  userFiled ,filed,value ));
		this.userFiled = userFiled;
		this.filed = filed;
		this.value = value;
	}
	
	
}
