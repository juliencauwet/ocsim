import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable, Subject} from "rxjs";
import {Event} from "../model/Event.option";
import {error} from "util";
import {catchError, tap} from "rxjs/operators";
import {Room} from "../model/Room.option";

@Injectable({
  providedIn: 'root'
})
export class RoomsService {

  readonly ALL_ROOMS_URL = 'http://localhost:9000/rooms/';
  readonly LAST_EVENT_URL = 'http://localhost:9000/events/room/1';

  roomSubject = new Subject<any[]>();
  private rooms = [];
  private event: Event;

  constructor(private httpClient: HttpClient) { }

  emitRoomSubject(){
    this.roomSubject.next(this.rooms.slice());
  }


  getRooms(): Observable<Room[]>{
    return this.httpClient
      .get<any[]>(this.ALL_ROOMS_URL);
  }

  //getLastEvent(id : number): Observable<Event>{
  //  console.log("dans getLastEvent" + id);
  //  return this.httpClient
  //    .get<Event>(this.LAST_EVENT_URL)
  //    .pipe(
  //      tap(
  //        event =>console.log("temps de l'event: " + event.time)
  //      )
  //    );
  //}

  getLastEvent(id:number){
    let promise = new Promise(
      (resolve, reject) => {
        this.httpClient.get(this.LAST_EVENT_URL)
          .toPromise()
          .then(
            res => {console.log(res)});
      }
    );
    return promise;
  }

}
