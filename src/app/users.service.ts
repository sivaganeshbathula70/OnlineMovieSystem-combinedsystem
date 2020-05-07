import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Users } from './users';
import { Ticket } from './Ticket';
@Injectable({
  providedIn: 'root'
})
export class UsersService {
  
  private ticketsBookedDate:Date;
  private ticket:Ticket=new Ticket();
  getdisplay(): Users {
    throw new Error("Method not implemented.");
  }
  
  
  

  private users: Users[]=[];
  
  private baseUrl = 'http://localhost:8089/';
  updateStudent: any;
  getStudentList: any;

  constructor(private http: HttpClient) { }
/***************************************
	*       @author           Bathula SIVA GANESH
	*       Description       It is a request that gives us an option to add screens.
	*       version           1.0
	*       created date      21-APR-2020
	*         
	****************************************/

  insertUser(user:Users):Observable<any>{

    return this.http.post("http://localhost:8089/screen",user);
  }
/***************************************
	*       @author           Bathula SIVA GANESH
	*       Description       It is a http request that shows the screens.
	*       version           1.0
	*       created date      21-APR-2020
	*         
	****************************************/
  loadusers():Observable<any>{
    return this.http.get("http://localhost:8089/getdisplay");
  }
  /***************************************
	*       @author           Bathula SIVA GANESH
	*       Description       It is a request that allows us to delete screen.
	*       version           1.0
	*       created date      21-APR-2020
	*         
	****************************************/
  deletescreen(id:Number):Observable<any>{
    
    //return this.http.delete("http://localhost:8089/delete/${id}");
    return this.http.delete(`${this.baseUrl}/delete/${id}`, { responseType: 'text' }); 
  }
  viewUserbyId(id:number):Observable<any>
  {
    let endpoint=id;
    return this.http.get("http://localhost:8089/viewscreenDetails/"+endpoint);
  } 
  /***************************************
	*       @author           Bathula SIVA GANESH
	*       Description       It is arequest that allows us to update the screens.
	*       version           1.0
	*       created date      21-APR-2020
	*         
	****************************************/
  updateUser(user:Users):Observable<any>
  {
    let end=user.screeinId;
    return this.http.put("http://localhost:8089/update/"+end,user);
  }
  //loadusers1():Obervable<any>{
   //let endpoint = customerId;
   // return this.http.get("http://localhost:8089/getList");
 // }
loadusers1():Observable<any>
{
  return this.http.get("http://localhost:8089/getList");
}
setTicketsBookedDate(date:Date):void{
  this.ticketsBookedDate=date;
}
getTicketsBookedDate():Date{
  return this.ticketsBookedDate;
}

setTicket(ticket:Ticket):void{
  this.ticket=ticket;
}
getTicket():Ticket{
  return this.ticket;
}
/***************************************
	*       @author           Bathula SIVA GANESH
	*       Description       It is a  request that displays us the Ticket of customer
	*       version           1.0
	*       created date      21-APR-2020
	*         
	****************************************/
loadTicket():Observable<any>{
  let end=178;
  return this.http.get("http://localhost:8089/getTicketDetails/"+end);
 
}
/***************************************
	*       @author           Bathula SIVA GANESH
	*       Description       It is a request that allows us to cancel Booking
	*       version           1.0
	*       created date      21-APR-2020
	*         
	****************************************/
getcanBeCacelledTickets():Observable<any>{
  let end=17887;
  return this.http.get("http://localhost:8089/canBeCancelledTicket/"+end);
}
/***************************************
	*       @author           Bathula SIVA GANESH
	*       Description       It is a request that allows us to get Ticket of Today.
	*       version           1.0
	*       created date      21-APR-2020
	*         
	****************************************/
getTodayTickets():Observable<any>{
  let end=17887;
  return this.http.get("http://localhost:8089/todayTickets/"+end);
}
/***************************************
	*       @author           Bathula SIVA GANESH
	*       Description       It is a  request that allows us to display completed Tickets
	*       version           1.0
	*       created date      21-APR-2020
	*         
	****************************************/
getCompletedTickets():Observable<any>{
  let end=177;
  return this.http.get("http://localhost:8089/completedTickets/"+end);

}
/***************************************
	*       @author           Bathula SIVA GANESH
	*       Description       It is a request that allows us to cancel Tickes based on Ticket Id.
	*       version           1.0
	*       created date      21-APR-2020
	*         
	****************************************/
cancelTicket(ticketId:number):Observable<any>{
  let end=ticketId;
  return this.http.put("http://localhost:8089/cancelTicket/"+end,{});
}
}