import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CreereventemploiComponent } from './creereventemploi.component';

describe('CreereventemploiComponent', () => {
  let component: CreereventemploiComponent;
  let fixture: ComponentFixture<CreereventemploiComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CreereventemploiComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CreereventemploiComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
