import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CreerenseignatComponent } from './creerenseignat.component';

describe('CreerenseignatComponent', () => {
  let component: CreerenseignatComponent;
  let fixture: ComponentFixture<CreerenseignatComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CreerenseignatComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CreerenseignatComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
