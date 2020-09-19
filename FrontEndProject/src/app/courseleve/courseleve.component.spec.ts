import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CourseleveComponent } from './courseleve.component';

describe('CourseleveComponent', () => {
  let component: CourseleveComponent;
  let fixture: ComponentFixture<CourseleveComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CourseleveComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CourseleveComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
