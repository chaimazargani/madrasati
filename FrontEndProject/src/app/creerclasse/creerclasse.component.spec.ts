import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CreerclasseComponent } from './creerclasse.component';

describe('CreerclasseComponent', () => {
  let component: CreerclasseComponent;
  let fixture: ComponentFixture<CreerclasseComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CreerclasseComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CreerclasseComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
