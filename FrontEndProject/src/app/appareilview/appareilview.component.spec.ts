import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AppareilviewComponent } from './appareilview.component';

describe('AppareilviewComponent', () => {
  let component: AppareilviewComponent;
  let fixture: ComponentFixture<AppareilviewComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AppareilviewComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AppareilviewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
