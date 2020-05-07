package com.cg.movie.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



@Entity
@Table(name="lpu_movie_theater")
public class Theater{
	@Id
	@Column(name="theaterId")
	private int theaterId;
	@Column(name="theaterName",length=25)
	private String theaterName;
	@Column(name="theaterCity",length=25)
	private String theaterCity;
	@Column(name ="managerName",length=25)
	private String managerName;
	@Column(name ="managerContact",length=10)
	private String managerContact;
	public String getManagerContact() {
		return managerContact;
	}
	public void setManagerContact(String managerContact) {
		this.managerContact = managerContact;
	}
	public Movie getMovie() {
		return movie;
	}
	public void setMovie(Movie movie) {
		this.movie = movie;
	}
	@ManyToOne
	@JoinColumn(name="movieId", referencedColumnName = "movie_Id")
	private Movie movie;
	
	
	public String getTheaterCity() {
		return theaterCity;
	}
	public void setTheaterCity(String theaterCity) {
		this.theaterCity = theaterCity;
	}
	public String getManagerName() {
		return managerName;
	}
	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}
	
	public int getTheaterId() {
		return theaterId;
	}
	public void setTheaterId(int theaterId) {
		this.theaterId = theaterId;
	}
	public String getTheaterName() {
		return theaterName;
	}
	public void setTheaterName(String theaterName) {
		this.theaterName = theaterName;
	}
	
	
	
}
