import { Component, OnInit } from '@angular/core';
import {Room} from "../model/Room.option";

@Component({
  selector: 'app-room-list',
  templateUrl: './room-list.component.html',
  styleUrls: ['./room-list.component.css']
})
export class RoomListComponent implements OnInit {

  rooms: Room[];

  constructor() { }

  ngOnInit() {
  }

}
