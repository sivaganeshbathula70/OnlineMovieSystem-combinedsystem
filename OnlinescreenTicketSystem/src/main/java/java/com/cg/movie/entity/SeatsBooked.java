package com.cg.movie.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="lpu_movie_booked")
public class SeatsBooked {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)  
	@Column(name="sNo")
	private int id;
	@Column(name="booking_id")
	private int bookingId;
	@Column(name="seatNo")
	private int seatNo;
	
	public int getSeatNo() {
		return seatNo;
	}
	public void setSeatNo(int seatNo) {
		this.seatNo = seatNo;
	}
	public int getBookingId() {
		return bookingId;
	}
	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}
	public SeatsBooked( int bookingId, int seatNo) {
		
		
		this.bookingId = bookingId;
		this.seatNo = seatNo;
	}


}
