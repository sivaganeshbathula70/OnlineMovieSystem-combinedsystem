package com.cg.movie.exception;

public class MovieBookingException1  extends RuntimeException{
	private static final long serialVersionUID = 1L;

	public MovieBookingException1(String msg) {
		super(msg);
}
	public MovieBookingException1(String msg,Throwable t)
	{
		super(msg,t);
	}
}