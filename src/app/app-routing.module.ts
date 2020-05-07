import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AdduserComponent } from './adduser/adduser.component';
import { ViewuserComponent } from './viewuser/viewuser.component';
import {UpdateComponent }    from './update/update.component';
import {TicketDisplayComponent}   from './ticket-display/ticket-display.component';


const routes: Routes = [
         { path: 'AddScreen', component: AdduserComponent },
         {path:'viewUscreens',component:ViewuserComponent},
         {path:'updateScreen',component:UpdateComponent},
         {
           path:'viewTickets',component: TicketDisplayComponent},
           { path: '', redirectTo: '/viewUscreens', pathMatch: 'full' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
