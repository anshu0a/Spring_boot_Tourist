package com.an.exceptions;

public class TouristNotFoundException extends Exception {
	
	private static final long serialVersionUID = 1L;

	public TouristNotFoundException() {}
	
	public TouristNotFoundException(String msg) {
		super(msg);
	}

}
