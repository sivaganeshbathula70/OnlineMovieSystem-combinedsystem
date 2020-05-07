package com.cg.movie.entity;
import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="lpu_movie_Ticket")
public class Ticket {
@Id
@Column(name="ticket_id")
private int ticketId;
@Column(name="noofseats")
private int noOfSeats;
@Column(name="customerId")
private int customerId;
@Column(name="status")
private int status;

public int getStatus() {
	return status;
}

public void setStatus(int status) {
	this.status = status;
}

public int getCustomerId() {
	return customerId;
}

public void setCustomerId(int customerId) {
	this.customerId = customerId;
}
@ManyToOne
@JoinColumn(name="booking_id",referencedColumnName="booking_Id")
private Booking booking;



public int getTicketId() {
	return ticketId;
}
public void setTicketId(int ticketId) {
	this.ticketId = ticketId;
}
public int getNoOfSeats() {
	return noOfSeats;
}
public void setNoOfSeats(int noOfSeats) {
	this.noOfSeats = noOfSeats;
}

public Booking getBooking() {
	return booking;
}
public void setBooking(Booking booking) {
	this.booking = booking;
}

public Ticket(int ticketId, int noOfSeats, int customerId, int status, Booking booking) {
	
	this.ticketId = ticketId;
	this.noOfSeats = noOfSeats;
	this.customerId = customerId;
	this.status = status;
	this.booking = booking;
}

public Ticket()
{
	
}

}
