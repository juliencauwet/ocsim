import {Component, OnDestroy, OnInit} from '@angular/core';
import {RoomsService} from "../../services/rooms.service";
import {Event} from "../../model/Event.option";

@Component({
  selector: 'app-room-list',
  templateUrl: './room-list.component.html',
  styleUrls: ['./room-list.component.css']
})
export class RoomListComponent implements OnInit , OnDestroy{

  rooms: any;
  event: Event;

  constructor(private roomService: RoomsService) {
  }

  ngOnInit() {
    this.getRooms();
    //this.getLastEvent(+1).subscribe(
    //  (event) => {
    //    // @ts-ignore
    //    this.event = event;
    //    console.log(event)
    //  }
    //);
    //console.log('last event: ' + this.getLastEvent( +2));
  }

  getRooms() {
    this.rooms = this.roomService.getRooms();
  }

  getLastEvent(id : number) : Date{
    console.log('getLastEvent method');
    let event: any;
    this.roomService.getLastEvent(+id).then(
          data => {event = data;}
    );
    return this.getEventTime(event);
  }

  getEventTime(event: Event){
    return event.time;
  }

  ngOnDestroy(): void {
  }
}




