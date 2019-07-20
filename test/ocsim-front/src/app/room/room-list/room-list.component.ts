import { Component, OnInit } from '@angular/core';
import {Room} from "../../model/Room.option";
import {RoomsService} from "../../services/rooms.service";
import {HttpClient} from "@angular/common/http";

@Component({
  selector: 'app-room-list',
  templateUrl: './room-list.component.html',
  styleUrls: ['./room-list.component.css']
})
export class RoomListComponent implements OnInit {

  rooms: any;
  event;

  readonly ALL_ROOMS_URL = 'http://localhost:9000/rooms/';

  readonly LAST_EVENT_URL = 'http://localhost:9000/events/room/';

  constructor(private roomService: RoomsService, private httpClient: HttpClient) {
  }

  ngOnInit() {
    this.getRooms();
  }

  getRooms() {
    this.rooms = this.httpClient.get(this.ALL_ROOMS_URL);
  }

  getLastEvent(id : number){
    let event;
      event = this.httpClient.get(this.LAST_EVENT_URL + id);
      console.log("event:" + event.time);
      console.log(this.LAST_EVENT_URL + id);
      console.log(this.httpClient.get(this.LAST_EVENT_URL + id));
      return event.time;
  }
}




