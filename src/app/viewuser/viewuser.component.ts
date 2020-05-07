import { Component, OnInit } from '@angular/core';
import { UsersService } from '../users.service';
import { Users } from '../users';
import { FormGroup, FormControl } from '@angular/forms';
import { Observable } from 'rxjs';


@Component({
  selector: 'app-viewuser',
  templateUrl: './viewuser.component.html',
  styleUrls: ['./viewuser.component.css']
})
export class ViewuserComponent implements OnInit {
  students: Observable<Users[]>;  
  users:Users []=[];
  deleteMessage=false;
  Userslist: any;
 
  constructor(private usersService:UsersService) { }
/***************************************
	*       @author           Bathula SIVA GANESH
	*       Description       It is a load Function that allows to Load screen Data
	*       version           1.0
	*       created date      21-APR-2020
	*         
	****************************************/
  ngOnInit(): void {
    this.usersService.loadusers().subscribe(data=>this.users=data);
  }
  /***************************************
	*       @author           Bathula SIVA GANESH
	*       Description       It is a  Delete Function that allows to delete Data.
	*       version           1.0
	*       created date      21-APR-2020
	*         
	****************************************/
deletescreen(id:number): void {
  let r = confirm("Are You Sure You want To delete?");
  if (r)
    this.usersService.deletescreen(id).subscribe(  
      data => {  
        console.log(data);  
        this.deleteMessage=true;  
        this.usersService.loadusers().subscribe(data =>{  
          this.users =data  
          })  
      },  
      error => console.log(error));  
}  ;


}
