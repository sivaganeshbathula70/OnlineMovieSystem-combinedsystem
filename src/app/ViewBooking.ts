import { ViewShow } from './ViewShow';
import { ViewMovie } from './ViewMovie';

export class ViewBooking{
    bookingDate:Date;
    ticketsBookedDate:Date;
    totalCost:number;
    show:ViewShow;
    movie:ViewMovie;
}