import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Subject} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class RoomsService {

  roomSubject = new Subject<any[]>();
  private rooms= [];

  constructor(private httpClient: HttpClient) { }

  emitRoomSubject(){
    this.roomSubject.next(this.rooms.slice());
  }

  getRoomsFromServer() {
    this.httpClient
      .get<any[]>('http://localhost:8642/campaign/current')
      .subscribe(
        (response) => {
          this.rooms = response;
          console.log(response.length);
          for (const room of this.rooms) {
            console.log('campaign id: ' + room.id + ': ' + room.question);
          }
          this.emitRoomSubject();
        },
        // tslint:disable-next-line:no-shadowed-variable
        (error) => {
          console.log('Erreur de chargement' + error);
        }
      );

  }
}
