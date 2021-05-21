import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CapitallistComponent } from './capitallist.component';

describe('CapitallistComponent', () => {
  let component: CapitallistComponent;
  let fixture: ComponentFixture<CapitallistComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CapitallistComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CapitallistComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
