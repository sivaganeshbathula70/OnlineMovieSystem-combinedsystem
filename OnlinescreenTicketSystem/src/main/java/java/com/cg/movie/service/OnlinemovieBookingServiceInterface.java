package com.cg.movie.service;

import java.util.List;

import com.cg.movie.entity.BookingState;
import com.cg.movie.entity.Screen;
import com.cg.movie.entity.Seat;
import com.cg.movie.entity.Ticket;
import com.cg.movie.entity.user;
import com.cg.movie.exception.MovieBookingException;

public interface OnlinemovieBookingServiceInterface {
	
	public List<Screen> display();
	public Screen  create(Screen screen);
public Screen getScreenInfo(int screenId);
	List<Seat> reterive();
	public void delete(int screen);
	public Screen update(int screenId,String theatername,String screentype,String screenname,int screenrows,int columns);

	
	

	List<Ticket> getTicketDetails(int customerId);
	boolean cancelBooking(int bookingId) throws MovieBookingException;
	boolean cancelTicket(int ticketId) throws MovieBookingException;
	List<Ticket> getCanBeCancelledTickets(int customerId);
	List<Ticket> gettodayTickets(int customerId);
	List<Ticket> getcompletedTickets(int customerId);
}
