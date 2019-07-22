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
  }

  getRooms() {
    this.rooms = this.roomService.getRooms();
  }

  getLastEvent(id : number){
    console.log('getLastEvent method');
  }

  getEventTime(event: Event){
    return event.time;
  }

  ngOnDestroy(): void {
  }
}




