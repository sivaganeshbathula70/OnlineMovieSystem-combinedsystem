import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ScheduleFlightComponent } from './schedule-flight/schedule-flight.component';
import { AdduserComponent } from './adduser/adduser.component';
import {HttpClientModule} from '@angular/common/http';
import {FormsModule} from '@angular/forms';
import { ViewuserComponent } from './viewuser/viewuser.component';
import { UpdateComponent } from './update/update.component';

import { TicketDisplayComponent } from './ticket-display/ticket-display.component';
@NgModule({
  declarations: [
    AppComponent,
    ScheduleFlightComponent,
    AdduserComponent,
    ViewuserComponent,
    UpdateComponent,
    TicketDisplayComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
