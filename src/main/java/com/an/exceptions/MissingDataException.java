package com.an.exceptions;

public class MissingDataException extends Exception {
	
	private static final long serialVersionUID = 1L;

	public MissingDataException(){
		super();
	}
	
	public MissingDataException(String msg){
		super(msg);
	}
	
}
