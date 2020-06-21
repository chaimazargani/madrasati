import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CreermatierComponent } from './creermatier.component';

describe('CreermatierComponent', () => {
  let component: CreermatierComponent;
  let fixture: ComponentFixture<CreermatierComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CreermatierComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CreermatierComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
