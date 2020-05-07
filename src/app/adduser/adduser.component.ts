import { UsersService } from './../users.service';
import { Component, OnInit ,ViewChild} from '@angular/core';
import { Users } from '../users';
import {NgForm}  from "@angular/forms";
import { Router } from '@angular/router';

@Component({
  selector: 'app-adduser',
  templateUrl: './adduser.component.html',
  styleUrls: ['./adduser.component.css']
})
export class AdduserComponent implements OnInit {
@ViewChild("#frm")
form:NgForm;
  usertype:string[]=['Admin','Customer'];

  users:Users=new Users();
  router: any;

  constructor(private userService:UsersService,private route:Router) { }


  ngOnInit(): void {
  }
  /***************************************
	*       @author           Bathula SIVA GANESH
	*       Description       It is a  insert function that allows us to insert  data.
	*       version           1.0
	*       created date      21-APR-2020
	*         
	****************************************/
  insertUser()
  {
    this.userService.insertUser(this.users).subscribe(data=>{this.users=data;},
    
    );
    
  this.route.navigateByUrl("/viewUscreens");

}
}
