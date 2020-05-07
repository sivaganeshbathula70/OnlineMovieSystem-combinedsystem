package com.cg.movie.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;



public class ExceptionController {
	@ExceptionHandler(value = MovieBookingException.class)
	public ResponseEntity<Object> handleException(MovieBookingException exception) {
		return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
	}

	public class ExceptionController1 {
		@ExceptionHandler(value = MovieBookingException1.class)
		public ResponseEntity<Object> handleException(MovieBookingException1 exception) {
			return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
		}

	}
}

