package com.cg.movie.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.movie.entity.BookingState;
import com.cg.movie.entity.Screen;
import com.cg.movie.entity.Seat;
import com.cg.movie.entity.Ticket;
import com.cg.movie.entity.user;
import com.cg.movie.exception.MovieBookingException;
import com.cg.movie.service.OnlinemovieBookingServiceInterface;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class OnlineMovieBookingController {
	@Autowired
	OnlinemovieBookingServiceInterface service;

	/***************************************
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
	*       @author           Bathula SIVA GANESH
	*       Description       It is a controller that provides  for get Mapping requests	*       version           1.0
	*       created date      21-APR-2020     
	*       
	*       
	****************************************/


	
	
	@GetMapping("/getdisplay")
	public List<Screen> display(){
		List<Screen> userList1= service.display();
		return  userList1;
	}
	
		

	/***************************************
	 * 
	*       @author           Bathula SIVA GANESH
	*       Description       It is a controller that handles get Mapping requests of particular controller.
	*       version           1.0
	*       created date      21-APR-2020     
	*       
	****************************************/

	
	
	@GetMapping("/viewscreenDetails/{id}")
	public ResponseEntity<Screen> viewscreenDetails1(@PathVariable("id") int screenId)
	{
		Screen screen=service.getScreenInfo(screenId);
		return new ResponseEntity<Screen>(screen,HttpStatus.OK);
		
		
	}

	/***************************************
	 * 
	*       @author           Bathula SIVA GANESH
	*       Description       It is a controller class that handles post mapping Requests.
	*       version           1.0
	*       created date      21-APR-2020      
	*       
	*       
	****************************************/

	@PostMapping("/screen")
	public ResponseEntity<String>saveScreen(@RequestBody Screen screen) {
        service.create(screen);
      
    	      	   
       
		return new ResponseEntity<String>("Added screen successfully",HttpStatus.OK);
    	   
       
	}

	/***************************************
	 * 
	*       @author           Bathula SIVA GANESH
	*       Description       It is a controller that handles delete mapping requests.
	*       version           1.0
	*       created date      21-APR-2020
   
	*    
	****************************************/

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Object> deleteTrainer(@PathVariable("id") int screenId)
	{
	 	service.delete(screenId);
		return new ResponseEntity<>("Deleted ",HttpStatus.OK);
	}
	

	/***************************************
	*       @author           Bathula SIVA GANESH
	*       Description       It is a controller class that handles put Requests.
	*       version           1.0
	*       created date      21-APR-2020   
	*       
	****************************************/

	@PutMapping("/update/{id}")
	public ResponseEntity<Object> updateTrainer(@PathVariable("id") int screenId,@RequestBody Screen screen)
	{
	Screen screenupdate = service.update(screenId,screen.getScreenname(),screen.getShow(),screen.getTheatername(),screen.getScreenrows(),screen.getColumns());

			
		
	
		return new ResponseEntity<Object>(screenupdate,HttpStatus.OK);
	}
	

	
	/**************************************
	*       @author           Bathula SIVA GANESH
	*       Description       It is a controller class that handles delete Mapping Requests e details
	*       version           1.0
	*       created date      21-APR-2020   
	*       
	****************************************/

	
		@DeleteMapping("/deleteticket/{customerId}")
	public ResponseEntity<List<Ticket>> cancelTickets(@PathVariable("customerId") int customerId)
	{
	 	service.cancelTicket(customerId);
	
		return new ResponseEntity<List<Ticket>>(HttpStatus.OK);
	}

		/***************************************
		*       @author           Bathula SIVA GANESH
		*       Description       It is a controller class that handles get Mapping Requests.
		*       version           1.0
		*       created date      21-APR-2020     
		*       
		****************************************/

	@GetMapping("/getTicketDetails/{customerId}")
	public List<Ticket> getTicketDetails(@PathVariable("customerId") int customerId) {
		List<Ticket> ticketDetails=service.getTicketDetails(customerId);
		return ticketDetails;
	}

	/**************************************
	*       @author           Bathula SIVA GANESH
	*       Description       It is a controller class that handles  put  Mapping requests.
	*       version           1.0
	*       created date      21-APR-2020  
	****************************************/

	@DeleteMapping("/cancelTicket/{ticketId}")
	public void cancelTicket(@PathVariable("ticketId") int ticketId) 
	{
		service.cancelTicket(ticketId);
		String statement="Booking has been successfully deleted";
		//return statement;
		
		
	}

	/***************************************
	 * 
	*       @author           Bathula SIVA GANESH
	*       Description       It is a controller class that handles get Mapping Requests.
	*       version           1.0
	*       created date      21-APR-2020     
	****************************************/

	//http request for canceling the booking based on booking Id
			@GetMapping("/canBeCancelledTicket/{customerId}")
			public List<Ticket> canBeCancelledTickets(@PathVariable("customerId") int customerId) {
				List<Ticket> ticketDetails=service.getCanBeCancelledTickets(customerId);
				return ticketDetails;
             }

			/***************************************
			*       @author           Bathula SIVA GANESH
			*       Description       It is a controller class that handles get Mapping Requests.
			*       version           1.0
			*       created date      21-APR-2020   
			****************************************/

//http request for canceling the booking based on booking Id
    @GetMapping("/todayTickets/{customerId}")
		public List<Ticket> todayTickets(@PathVariable("customerId") int customerId) {
			List<Ticket> ticketDetails=service.gettodayTickets(customerId);
			return ticketDetails;
             }

	/***************************************
	*       @author           Bathula SIVA GANESH
	*       Description       It is a controller class that handles get Mapping Requests
	*       version           1.0
	*       created date      21-APR-2020
	*         
	****************************************/

    @GetMapping("/completedTickets/{customerId}")
		public List<Ticket> completedTickets(@PathVariable("customerId") int customerId) {
			List<Ticket> ticketDetails=service.getcompletedTickets(customerId);
			
			return ticketDetails;
             }
}
