package com.cg.movie.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.movie.dao.OnlinemovieBookingDAOInterface;
import com.cg.movie.entity.Booking;
import com.cg.movie.entity.BookingState;
import com.cg.movie.entity.Movie;
import com.cg.movie.entity.Screen;
import com.cg.movie.entity.Seat;
import com.cg.movie.entity.Show;
import com.cg.movie.entity.Theater;
import com.cg.movie.entity.Ticket;
import com.cg.movie.entity.user;
import com.cg.movie.exception.MovieBookingException;
import com.cg.movie.exception.MovieBookingException1;
@Service
@Transactional
public class OnlinemovieBookingService implements OnlinemovieBookingServiceInterface {

	
	@Autowired
	OnlinemovieBookingDAOInterface dao;
	
	
	
	
	
	
	

		@Override
		public List<Seat> reterive() {
			// TODO Auto-generated method stub
			return dao.reterive();
		}

		/***************************************
		*       @author           Bathula SIVA GANESH
		*       Description       It is a service that provides service for fetching screen details
		*       version           1.0
		*       created date      21-APR-2020      
		*       
		****************************************/

		@Override
		public List<Screen> display()throws MovieBookingException1
		{
			if(dao.display().size()>0)
			{
				
				return  dao.display();
			
			}
			else
			{
				
			
			throw new MovieBookingException1("no screens available");
			}
		}

		/***************************************
		 * 
		*       @author           Bathula SIVA GANESH
		*       Description       It is a service that provides service for fetching screeninformation details
		*       version           1.0
		*       created date      21-APR-2020    
		*       
		****************************************/

		@Override
		public Screen getScreenInfo(int screenId) {
			// TODO Auto-generated method stub
			return dao.getScreenInfo(screenId);
		}
		
		@Override
		
		public Screen create(Screen screen)throws MovieBookingException
		{
		if(dao.create(screen)==null) 
		{
			throw new MovieBookingException("no data");
		}
		else
		{
			Screen data= dao.create(screen);
			return data;
		}
			
		}

		/***************************************
		*       @author           Bathula SIVA GANESH
		*       Description       It is a service that provides service for deleting details
		*       version           1.0
		*       created date      21-APR-2020   
		*       
		****************************************/

		@Override
		public void delete(int screen) {
			// TODO Auto-generated method stub
			dao.delete(screen);
		
			
			
			
		}

		/***************************************
		 * 
		*       @author           Bathula SIVA GANESH
		*       Description       It is a service that provides service for updating  details
		*       version           1.0
		*       created date      21-APR-2020    
		*       
		****************************************/

		@Override
		public Screen update(int screenId, String theatername, String screentype, String screenname,int screenrows,int columns) {
			// TODO Auto-generated method stub
			dao.update(screenId, theatername, screentype, screenname,screenrows,columns);
		return null;
			
		}
		
		

				
		/***************************************
		 * 
		*       @author           Bathula SIVA GANESH
		*       Description       It is a service that provides service for fetching ticketDetails details
		*       version           1.0
		*       created date      21-APR-2020   
		*       
		****************************************/


				@Override
		public List<Ticket> getTicketDetails(int customerId) {
					Booking bk = new Booking();
					
					
				
					
		 List<Ticket> ticket=dao.getTicketDetails(customerId);
			return ticket;
		}
		@Override
		public boolean cancelBooking(int bookingId) throws MovieBookingException {
			Booking booking = dao.getBookingDetails(bookingId);
			if(booking==null)
			{
				throw new MovieBookingException("booking id "+bookingId+" is not found");
			}
			dao.removeBooking(booking);
			return true;
		}
		@Override
		public boolean cancelTicket(int ticketId) throws MovieBookingException {
			Ticket ticket = dao.getTicket(ticketId);
			if(ticket==null)
			{
				throw new MovieBookingException("booking id "+ticketId+" is not found");
			}
			
			cancelBooking(ticket.getBooking().getBookingid());
			dao.removeBooking(ticket);
			return true;
		}

		/***************************************
		 * 
		*       @author           Bathula SIVA GANESH
		*       Description       It is a service that provides service for cancelling Booking Details details
		*       version           1.0
		*       created date      21-APR-2020   
		*       
		****************************************/

		@Override
		public List<Ticket> getCanBeCancelledTickets(int customerId) {
			 List<Ticket> ticketList=dao.getTicketDetails(customerId);
			 List<Ticket> canBeCancelledTickets=new ArrayList<Ticket>();
			 for(Ticket ticket:ticketList)
			 {
				 if(LocalDate.now().compareTo(ticket.getBooking().getTicketsBookedDate())<0) {
						canBeCancelledTickets.add(ticket);
					}
			 }
			return canBeCancelledTickets;
		}

		/***************************************
		 * 
		*       @author           Bathula SIVA GANESH
		*       Description       It is a service that provides service for fetching Tickets of Today details
		*       version           1.0
		*       created date      21-APR-2020      
		*       
		****************************************/

		@Override
		public List<Ticket> gettodayTickets(int customerId) {
			 List<Ticket> ticketList=dao.getTicketDetails(customerId);
			 List<Ticket> canBeCancelledTickets=new ArrayList<Ticket>();
			 for(Ticket ticket:ticketList)
			 {
				 if(LocalDate.now().compareTo(ticket.getBooking().getTicketsBookedDate())==0) {
						canBeCancelledTickets.add(ticket);
					}
			 }
			return canBeCancelledTickets;
			
		}

		/************************************** 
		*       @author           Bathula SIVA GANESH
		*       Description       It is a service that provides service for fetching completed Ticket Details details
		*       version           1.0
		*       created date      21-APR-2020
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
		****************************************/

		@Override
		public List<Ticket> getcompletedTickets(int customerId) {
			List<Ticket> ticketList=dao.getTicketDetails(customerId);
			 List<Ticket> canBeCancelledTickets=new ArrayList<Ticket>();
			 for(Ticket ticket:ticketList)
			 {
				 if(LocalDate.now().compareTo(ticket.getBooking().getTicketsBookedDate())>0) {
						canBeCancelledTickets.add(ticket);
					}
			 }
			return canBeCancelledTickets;
		}


		

		}

