import {Component, Input, OnInit} from '@angular/core';
import {Room} from "../../model/Room.option";

@Component({
  selector: 'app-room-nail',
  templateUrl: './room-nail.component.html',
  styleUrls: ['./room-nail.component.css']
})
export class RoomNailComponent implements OnInit {

  @Input() roomIndex: number;
  @Input() name: string;
  @Input() availability: boolean;

  constructor() { }

  ngOnInit() {
  }

}
