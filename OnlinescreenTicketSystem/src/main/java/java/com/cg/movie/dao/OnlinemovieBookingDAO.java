package com.cg.movie.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.cg.movie.entity.Booking;
import com.cg.movie.entity.BookingState;
import com.cg.movie.entity.Screen;
import com.cg.movie.entity.Seat;
import com.cg.movie.entity.Ticket;
import com.cg.movie.entity.user;
import com.cg.movie.exception.MovieBookingException;

@Repository
public class OnlinemovieBookingDAO implements OnlinemovieBookingDAOInterface{
	@PersistenceContext
	EntityManager entityManager;
	Seat seat=new Seat();
	

	@Override
	public double getPrice(int seatId) {
		
		Seat s1=entityManager.find(Seat.class, seatId);
		if(s1==null)
		{
			 throw new MovieBookingException("seat id is not found"+seatId);
		}
		return s1.getSeatPrice();
	}


	@Override
	public List<user> getUserDetails() {
		String jquery="from user user";
		TypedQuery<user> query=entityManager.createQuery(jquery, user.class);
		return query.getResultList();
	}
	
	/**********************************
     *Method:getSeat
     *description:To fetch the Seat details from database.
     *seatId               -fetches the details of that particular id
     *@returns                 - seat details
     *@throws MovieBookingExceptionException -it is raised due to invalid id
     *created by               - BATHULA SIVA GANESH
     *created date             -21-APR-2020
**********************************/
	
	
	
	
	
	@Override
	public List<Seat> reterive() {
		String Qstr="SELECT seat FROM Seat seat";
		TypedQuery<Seat> query=entityManager.createQuery(Qstr,Seat.class);
		return query.getResultList();	
	}
	
	/**********************************
     *Method:displayscreen
     *description:To fetch the Screen details from database.
     *seatId               -fetches the details of screen
     *@returns                 - screen details
     *@throws MovieBookingExceptionException -it is raised due to invalid id
     *created by               - BATHULA SIVA GANESH
     *created date             -21-APR-2020
**********************************/
	@Override
	public List<Screen> display() {
		String Qstr="SELECT screen FROM Screen screen";
		TypedQuery<Screen> query=entityManager.createQuery(Qstr,Screen.class);
		return query.getResultList();	
	}

	
	
	/**********************************
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
     *Method:getseat
     *description:To fetch the seat status  details from database.
     *seatId               -fetches the details of that particular id
     *@returns                 -seat starusdetails
     *@throws Movie Exception -it is raised due to invalid id
     *created by               -  BATHULA SIVA GANESH
     *created date             -21-APR-2020
     *
     *
     *
     *
     *
     *
     *
     *
     *
     *
     *
**********************************/
	@Override
public BookingState getseat(int seatId) {
		
		Seat s1=entityManager.find(Seat.class, seatId);
		if(s1==null)
		{
			 throw new MovieBookingException("seat  is not found"+seatId);
		}
		return s1.getSeatStatus();
	}
	
	@Override
	public Seat blockseat(int s)
	{
		Seat su = entityManager.find(Seat.class, s);
		if(su.getSeatId()==s)
		{
		su.setSeatStatus(null);
			return null;
		}
		return su;
		}

	/**********************************
     *Method:getScreenInfo
     *description:To fetch the Seat details from database.
     *screenId               -fetches the details of that particular id
     *@returns                 - screen details
     *@throws MovieBookingExceptionException -it is raised due to invalid id
     *created by               - BATHULA SIVA GANESH
     *created date             -21-APR-2020
**********************************/
	@Override
	public Screen getScreenInfo(int screenu) {
		// TODO Auto-generated method stub
		Screen screen = entityManager.find(Screen.class, screenu);
		if(screen.getScreeinId()==screenu)
		{
			return screen;
		
		}
		return screen;
	}
	/**********************************
     *Method:putscreen
     *description:To fadd screen details in to database.
     
     *@returns                 - screen details
     *@throws MovieBookingExceptionException -it is raised due to invalid id
     *created by               - BATHULA SIVA GANESH
     *created date             -21-APR-2020
**********************************/

	@Override
	public Screen create(Screen screen) {
		// TODO Auto-generated method stub
		 entityManager.persist(screen);
		return screen;
	}
	/**********************************
     *Method:delete
     *description:To delete screen details from database.
     *screenId            -fetches the details of that particular id
     *@returns                 - delete details
     *@throws MovieBookingExceptionException -it is raised due to invalid id
     *created by               - BATHULA SIVA GANESH
     *created date             -21-APR-2020
**********************************/
	@Override
	public void delete(int screen)
	{
	
	
			Screen trs=entityManager.find(Screen.class, screen);
			if(trs.getScreeinId()==screen)
			{
				
 entityManager.remove(trs);
			
		}
		

	}

	/**********************************
     *Method:update
     *description:To update the Screen details from database.
     *screenId               -fetches the details of that particular id
     *@returns                 - screen details
     *@throws MovieBookingExceptionException -it is raised due to invalid id
     *created by               - BATHULA SIVA GANESH
     *created date             -21-APR-2020
**********************************/
	@Override
	public void update(int screenId, String theatername, String show, String screenname,int screenrows,int columns) {
		// TODO Auto-generated method stub
		Screen s =entityManager.find(Screen.class, screenId);
		s.setScreenname(screenname);
		s.setShow(show);
		s.setTheatername(theatername);
		s.setScreenrows(screenrows);
		s.setColumns(columns);
		
	}


	


	
	
	/**********************************
     *Method:getTicketDetails
     *description:To fetch the TicketDetails details from database.
     *customerId               -fetches the details of that particular id
     *@returns                 - Ticket details
     *@throws MovieBookingExceptionException -it is raised due to invalid id
     *created by               - BATHULA SIVA GANESH
     *created date             -21-APR-2020
**********************************/
	

	@Override
	public List<Ticket> getTicketDetails(int customerId) {
		String jquery="from Ticket ticket where ticket.customerId=:mid ";
		TypedQuery<Ticket> query=entityManager.createQuery(jquery,Ticket.class);
		query.setParameter("mid", customerId);
		return query.getResultList();
	}
	@Override
	public Ticket getTicket(int ticketId) {
	       Ticket ticket=entityManager.find(Ticket.class,ticketId);		
			return ticket;		
		}
	/**********************************
     *Method:removeBooking
     *description:To remove Booking details from database.
     *removiebooking             -fetches the details of that particular id
     *@returns                 - remove Booking details
     *@throws MovieBookingExceptionException -it is raised due to invalid id
     *created by               - BATHULA SIVA GANESH
     *created date             -21-APR-2020
**********************************/
	@Override
	public boolean removeBooking(Booking booking) {
		entityManager.remove(booking);
	
		return true;
	}
	
	@Override
	public void removeBooking(Ticket ticket) {
		entityManager.remove(ticket);
		
				
	}
	/**********************************
     *Method:getBookingdetails
     *description:To get Booking details from database.
     *BookingId            -fetches the details of that particular id
     *@returns                 - returns Booking details
     *@throws MovieBookingExceptionException -it is raised due to invalid id
     *created by               - BATHULA SIVA GANESH
     *created date             -21-APR-2020
**********************************/
@Override
	public Booking getBookingDetails(int bookingId) {
		// TODO Auto-generated method stub
		Booking booking=entityManager.find(Booking.class, bookingId);
		return booking;
}
	
	@Override
	public List<Ticket> displayTickets(int customerId) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<Ticket> cancelTicket(int customerId) {
		// TODO Auto-generated method stub
		return null;
	}
}