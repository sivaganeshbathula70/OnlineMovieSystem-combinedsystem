import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UsersService } from '../users.service';
import { viewTicket } from '../viewTicket';

@Component({
  selector: 'app-ticket-display',
  templateUrl: './ticket-display.component.html',
  styleUrls: ['./ticket-display.component.css']
})
export class TicketDisplayComponent implements OnInit {

  viewTicket:viewTicket[]=[];
  view:boolean;
  cancel:boolean;
  today:boolean;
  completed:boolean;
  msg:String;

  constructor(private route:Router,private bookingservice:UsersService) { }
/***************************************
	*       @author           Bathula SIVA GANESH
	*       Description       It is a  functions that load tickets of particular customer.
	*       version           1.0
	*       created date      21-APR-2020
	*         
	****************************************/
  ngOnInit() {
    this.bookingservice.loadTicket().subscribe(data=>{
      this.viewTicket=data;console.log(this.viewTicket[0]);
    });
    this.view=false;
    this.cancel=true;
    this.today=true;
    this.completed=true;
  
  }
  viewTickets(){
    this.ngOnInit();
    this.view=false;
    this.cancel=true;
    this.today=true;
    this.completed=true;

  }
  /***************************************
	*       @author           Bathula SIVA GANESH
	*       Description       It is a function that allows customer to cancel his booking and tickets.
	*       version           1.0
	*       created date      21-APR-2020
	*         
	****************************************/
  cancelTickets(){
    this.bookingservice.getcanBeCacelledTickets().subscribe(data=>{this.viewTicket=data;console.log(this.viewTicket);});
    this.view=true;
    this.cancel=false;
    this.today=true;
    this.completed=true;
    
  }
  /***************************************
	*       @author           Bathula SIVA GANESH
	*       Description       It is a  function that allows us to  display Ticket of today
	*       version           1.0
	*       created date      21-APR-2020
	*         
	****************************************/
  todayTickets(){
    this.bookingservice.getTodayTickets().subscribe(data=>{
      this.viewTicket=data;
    });
    this.view=true;
    this.cancel=true;
    this.today=false;
    this.completed=true;


  }
  /***************************************
	*       @author           Bathula SIVA GANESH
	*       Description       It is a  function that displays the tickets history.
	*       version           1.0
	*       created date      21-APR-2020
	*         
	****************************************/
  completedTickets(){
    this.bookingservice.getCompletedTickets().subscribe(data=>{
      this.viewTicket=data;
    });
    this.view=true;
    this.cancel=true;
    this.today=true;
    this.completed=false;

  }
  cancelTicket(ticketId:number){
    this.bookingservice.cancelTicket(ticketId).subscribe(data=>{
      this.msg=data;
      console.log(data);
      this.ngOnInit();
      
       });
    
  }

}
