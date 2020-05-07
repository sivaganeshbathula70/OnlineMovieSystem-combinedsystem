package com.cg.movie;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.cg.movie.entity.Movie;
import com.cg.movie.entity.Seat;
import com.cg.movie.entity.Show;





@SpringBootApplication

public class OnlineMovieApplication 
{
	
	public static void main(String[] args) {
		SpringApplication.run(OnlineMovieApplication.class, args);
	

		
	}		
		
	}
		