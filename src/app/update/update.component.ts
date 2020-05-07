import { Component, OnInit ,ViewChild} from '@angular/core';
import { Users } from '../users';
import { UsersService } from '../users.service';
import {NgForm}  from "@angular/forms";
import { Router } from '@angular/router';
@Component({
  selector: 'app-update',
  templateUrl: './update.component.html',
  styleUrls: ['./update.component.css']
})
export class UpdateComponent implements OnInit {
  @ViewChild("#frm")
form:NgForm;
  users: Users[] = [];

  uservalue:Users=new Users();
  editFlag: boolean = false;
  ids:number;
  info:string=undefined;
  errorInfo:String;

  userProfile:Users=new Users();
  constructor(private usersService:UsersService,private route:Router) { }

  ngOnInit(): void {

       this.userProfile=this.usersService.getdisplay();
       console.log("view profile");

  }
/***************************************
	*       @author           Bathula SIVA GANESH
	*       Description       It is function that views user.
	*       version           1.0
	*       created date      21-APR-2020
	*         
	****************************************/
  viewUser(id:number)
  {
    this.usersService.viewUserbyId(id).subscribe(data=>{this.users=data});
  }
  /***************************************
	*       @author           Bathula SIVA GANESH
	*       Description       It is a  function that update screens
	*       version           1.0
	*       created date      21-APR-2020
	*         
	****************************************/
  updateUser(){
    this.usersService.updateUser(this.uservalue).subscribe(data=>
      {
        this.uservalue=data;
        this.info=data;
        this.errorInfo=undefined;
      },error=>{
        this.info=undefined;
        this.errorInfo=JSON.stringify(error.error.text);
      }
      );
      this.route.navigateByUrl("/viewUscreens");

    }
  
    
}
