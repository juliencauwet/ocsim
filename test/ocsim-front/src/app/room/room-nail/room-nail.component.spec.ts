import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RoomNailComponent } from './room-nail.component';

describe('RoomNailComponent', () => {
  let component: RoomNailComponent;
  let fixture: ComponentFixture<RoomNailComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RoomNailComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RoomNailComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
