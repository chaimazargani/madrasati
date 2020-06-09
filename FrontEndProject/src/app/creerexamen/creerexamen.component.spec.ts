import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CreerexamenComponent } from './creerexamen.component';

describe('CreerexamenComponent', () => {
  let component: CreerexamenComponent;
  let fixture: ComponentFixture<CreerexamenComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CreerexamenComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CreerexamenComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
