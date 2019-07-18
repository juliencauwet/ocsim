import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Subject} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class RoomsService {

  roomSubject = new Subject<any[]>();
  private rooms = [];

  constructor(private httpClient: HttpClient) { }

  emitRoomSubject(){
    this.roomSubject.next(this.rooms.slice());
  }

  getRoomsFromServer() {
    this.httpClient
      .get<any[]>('http://localhost:9000/rooms/')
      .subscribe(
        (response) => {
          this.rooms = response;
          for (const room of this.rooms) {
            console.log('room ' + room.id + ': ' + room.availability);
          }
          console.log(this.rooms);
          this.emitRoomSubject();
        },
        // tslint:disable-next-line:no-shadowed-variable
        (error) => {
          console.log('Erreur de chargement' + error);
        }
      );
  }

  getRooms(){
    this.getRoomsFromServer();
    console.log('rooms: ' + this.rooms);
    return this.rooms;
    this.emitRoomSubject();
    console.log('rooms: ' + this.rooms);
  }
}
