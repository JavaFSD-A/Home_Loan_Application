import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CapitaldetailsComponent } from './capitaldetails.component';

describe('CapitaldetailsComponent', () => {
  let component: CapitaldetailsComponent;
  let fixture: ComponentFixture<CapitaldetailsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CapitaldetailsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CapitaldetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
