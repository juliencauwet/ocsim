import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { RoomListComponent } from './room/room-list/room-list.component';
import {HttpClientModule} from "@angular/common/http";
import { RoomNailComponent } from './room/room-nail/room-nail.component';

@NgModule({
  declarations: [
    AppComponent,
    RoomListComponent,
    RoomNailComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
