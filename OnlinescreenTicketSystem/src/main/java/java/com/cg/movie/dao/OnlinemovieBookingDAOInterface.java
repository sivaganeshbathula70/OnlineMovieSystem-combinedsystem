package com.cg.movie.dao;

import java.util.List;

import com.cg.movie.entity.Booking;
import com.cg.movie.entity.BookingState;
import com.cg.movie.entity.Screen;
import com.cg.movie.entity.Seat;
import com.cg.movie.entity.Ticket;
import com.cg.movie.entity.user;

public interface OnlinemovieBookingDAOInterface {
	public double getPrice(int seatId);
	public List<user> getUserDetails();
	//public List<Seat> getSeatList();
	
	BookingState getseat(int seatId);
	Seat blockseat(int seatId);
	List<Seat> reterive();
	public List<Screen> display();

public Screen getScreenInfo(int screenu);
public Screen create(Screen screen);
public void delete(int screen);
public void update(int screenId,String theatername,String screentype,String screenname,int screenrows,int columns);
public List<Ticket>  displayTickets(int customerId);
public List<Ticket> cancelTicket(int customerId);
List<Ticket> getTicketDetails(int customerId);
Ticket getTicket(int ticketId);
boolean removeBooking(Booking booking);
void removeBooking(Ticket ticket);
//public Booking getBookingDetails(int bookingId);
public Booking getBookingDetails(int bookingId);
}
