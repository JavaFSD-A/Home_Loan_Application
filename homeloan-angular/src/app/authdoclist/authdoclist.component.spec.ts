import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AuthdoclistComponent } from './authdoclist.component';

describe('AuthdoclistComponent', () => {
  let component: AuthdoclistComponent;
  let fixture: ComponentFixture<AuthdoclistComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AuthdoclistComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AuthdoclistComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
