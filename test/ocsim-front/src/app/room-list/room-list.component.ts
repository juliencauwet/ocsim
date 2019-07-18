import { Component, OnInit } from '@angular/core';
import {Room} from "../model/Room.option";
import {RoomsService} from "../services/rooms.service";
import {HttpClient} from "@angular/common/http";

@Component({
  selector: 'app-room-list',
  templateUrl: './room-list.component.html',
  styleUrls: ['./room-list.component.css']
})
export class RoomListComponent implements OnInit {

  rooms: any;

  readonly ROOT_URL = 'http://localhost:9000/rooms/';

  constructor(private roomService: RoomsService, private httpClient: HttpClient) { }

  ngOnInit() {
    this.getRooms();
  }

  getRooms(){
    this.rooms = this.httpClient.get(this.ROOT_URL);
  }

}
